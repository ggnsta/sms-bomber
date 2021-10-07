package com.example.bomber;

import com.example.bomber.service.*;
import com.example.bomber.service.UsingServices.Discord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BomberApplication {

    public static void main(String[] args) {


        SpringApplication.run(BomberApplication.class, args);

       AtackManager am =new AtackManager();
       am.main();

    }

}
