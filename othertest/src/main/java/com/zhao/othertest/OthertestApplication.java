package com.zhao.othertest;

import com.zhao.othertest.aop.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableAspectJAutoProxy(exposeProxy = true)
public class OthertestApplication implements CommandLineRunner {

    @Autowired
    IPersonService iPersonService;

    public static void main(String[] args) {
        SpringApplication.run(OthertestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //嵌套再action 内部的work没有被代理
        iPersonService.action("hello world");

    }
}
