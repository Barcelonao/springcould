package com.zhao.othertest.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

@Service
public class HelloWorldService {

    @Async
    public void test(){
        System.out.println("Service ------->Start.....");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sercice ------->End........");
    }

}
