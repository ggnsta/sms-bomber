package com.example.bomber.Utilities;

import com.github.javafaker.Faker;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.GregorianCalendar;

@Data
public class FakeDataGenerator {

    private final Faker faker = new Faker();
    private final String name=generateName();
    private final String surname= generateSurname();
    private final String login = generateLogin();
    private final String password = generatePassword();
    private final GregorianCalendar birthday = generateBirthDate();


    private  String generateName() {
        return faker.name().firstName();
    }
    private  String generateSurname() {
        return faker.name().lastName();
    }

    private  String generateLogin()
    {
        String login = faker.name().username();
        login+=faker.random().nextInt(2000);
        return login;
    }

    public   void main(String[] args) {
        System.out.println(generatePassword());
        System.out.println(generateLogin());
        System.out.println(generateName());
        System.out.println(generateSurname());
        generateBirthDate();
    }

    private  String generatePassword() {
        String password = RandomStringUtils.randomAlphanumeric(12).toUpperCase();
        return password;
    }

    private GregorianCalendar generateBirthDate() {

        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(1900, 2003);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        // System.out.println(gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH));
        return gc;
    }

    private static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
