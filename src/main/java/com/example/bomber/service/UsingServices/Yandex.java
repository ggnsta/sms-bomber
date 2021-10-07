package com.example.bomber.service.UsingServices;

import com.example.bomber.Utilities.HttpRequestExecutor;
import com.example.bomber.Utilities.UserRequisite;
import com.example.bomber.service.SendingStrategy;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Yandex implements SendingStrategy {
    @Override
    public void createRequest(UserRequisite userRequisite) {
        String url="https://mobileproxy.passport.yandex.net/1/bundle/phone/confirm/submit";

        HttpPost request = new HttpPost(url);
        request.addHeader(HttpHeaders.CONTENT_TYPE,"application/x-www-form-urlencoded");
        List<NameValuePair> parameters = new ArrayList<>();
        parameters.add(new BasicNameValuePair("number", "+"+userRequisite.getPhoneNumber()));
        parameters.add(new BasicNameValuePair("display_language", "ru"));
        try {
            request.setEntity(new UrlEncodedFormEntity(parameters));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HttpRequestExecutor.sendPOST(request);
    }
}
