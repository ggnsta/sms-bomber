package com.example.bomber.Utilities;

import lombok.Data;
@Data
public class UserRequisite {


    private final FakeDataGenerator fakeData;
    private final String phoneNumber;

    public UserRequisite(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.fakeData = new FakeDataGenerator();
    }
}
