package com.example.bomber.Utilities;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.rmi.ServerException;

public class HttpRequestExecutor {
    private static final Logger logger = Logger.getLogger(HttpRequestExecutor.class);

    private static String checkStatusCode(HttpResponse response) throws IOException {

        switch (response.getStatusLine().getStatusCode()) {

            case 200:
                return  EntityUtils.toString(response.getEntity());
            case 404:
                throw new ServerException("Item wasn't found!");
            case 204:
                return "no content";
            case 409:
                throw new ServerException("The item already exists");
            default:
                throw new ServerException("Server error occurred!" + response.getStatusLine().getStatusCode());
        }
    }

    public static String sendPOST(HttpPost post) {

        String result = "";
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse closeableResponse = httpClient.execute(post)){
            result= checkStatusCode(closeableResponse);
        } catch(IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        logger.info(post.toString() +" was completed, with response: " +result);
        return result;
    }


}
