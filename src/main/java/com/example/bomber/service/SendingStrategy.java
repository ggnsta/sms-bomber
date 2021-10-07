package com.example.bomber.service;

import com.example.bomber.Utilities.UserRequisite;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public interface SendingStrategy {

    void createRequest(UserRequisite userRequisite);

}
