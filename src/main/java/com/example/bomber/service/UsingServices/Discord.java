package com.example.bomber.service.UsingServices;

import com.example.bomber.Utilities.HttpRequestExecutor;
import com.example.bomber.Utilities.UserRequisite;
import com.example.bomber.service.SendingStrategy;
import com.google.gson.JsonObject;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

public class Discord implements SendingStrategy {
    @Override
    public void createRequest(UserRequisite userRequisite) {
        String url="https://discord.com/api/v9/auth/register/phone";

        HttpPost request = new HttpPost(url);
        request.addHeader(HttpHeaders.CONTENT_TYPE,"application/json");
        JsonObject object = new JsonObject();
        object.addProperty("phone","+"+userRequisite.getPhoneNumber());
        StringEntity requestEntity = new StringEntity(object.toString(), ContentType.APPLICATION_JSON);
        request.setEntity(requestEntity);
        HttpRequestExecutor.sendPOST(request);
    }
}
