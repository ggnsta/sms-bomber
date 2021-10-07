package com.example.bomber.service.UsingServices;

import com.example.bomber.Utilities.HttpRequestExecutor;
import com.example.bomber.Utilities.UserRequisite;
import com.example.bomber.service.SendingStrategy;
import com.google.gson.JsonObject;
import org.apache.http.HttpHeaders;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;


//пока только смс для регистрации, сделать смс для восстановления.
//регистрация вроде без кд
//в случае успеха -204
public class AvBy implements SendingStrategy {

    @Override
    public void createRequest(UserRequisite userRequisite) {
        String url="https://api.av.by/auth/phone/sign-up";

        HttpPost request = new HttpPost(url);
        request.addHeader(HttpHeaders.CONTENT_TYPE,"application/json");
        JsonObject object = new JsonObject();
        object.addProperty("name","артем");
        object.addProperty("password", userRequisite.getFakeData().getPassword());
        JsonObject innerObject = new JsonObject();
        innerObject.addProperty("country",1); // вместо кода (375)
        innerObject.addProperty("number",userRequisite.getPhoneNumber().substring(3,12)); //44 123-45-67
        object.add("phone", innerObject);

        StringEntity requestEntity = new StringEntity(object.toString(), ContentType.APPLICATION_JSON);
        request.setEntity(requestEntity);
        HttpRequestExecutor.sendPOST(request);
    }
}
