package com.example.bomber.service;

import com.example.bomber.Utilities.UserRequisite;

public class AtackContext {
    private SendingStrategy sendingStrategy;
    private UserRequisite userRequisite;

    public AtackContext(String phoneNumber) {
        this.userRequisite = new UserRequisite(phoneNumber);
    }

    public void setSendingStrategy(SendingStrategy strategy)
    {
        this.sendingStrategy=strategy;
    }


    public void executeStrategy()
    {
        sendingStrategy.createRequest(this.userRequisite);
    }
}
