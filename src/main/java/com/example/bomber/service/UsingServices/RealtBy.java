package com.example.bomber.service.UsingServices;

import com.example.bomber.Utilities.HttpRequestExecutor;
import com.example.bomber.Utilities.UserRequisite;
import com.example.bomber.service.SendingStrategy;
import com.google.gson.JsonObject;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

//подряд может отправить
public class RealtBy implements SendingStrategy {
    private final String constant = "mutation initPhoneVerification($phone: String!) {\n  initPhoneVerification(phone: $phone) {\n    ...StatusAndErrors\n  }\n}\n\nfragment StatusAndErrors on INullResponse {\n  success\n  errors {\n    code\n    title\n    message\n    field\n  }\n}\n";
    @Override
    public void createRequest(UserRequisite userRequisite) {
        String url="https://realt.by/bff/graphql";

        HttpPost request = new HttpPost(url);
        request.addHeader(HttpHeaders.CONTENT_TYPE,"application/json");
        JsonObject object = new JsonObject();
        object.addProperty("operationName","initPhoneVerification");
        object.addProperty("query", constant);
        JsonObject innerObject = new JsonObject();
        innerObject.addProperty("phone",userRequisite.getPhoneNumber()); //375 29 1234567

        object.add("variables", innerObject);
        StringEntity requestEntity = new StringEntity(object.toString(), ContentType.APPLICATION_JSON);
        request.setEntity(requestEntity);
        HttpRequestExecutor.sendPOST(request);
    }
}
