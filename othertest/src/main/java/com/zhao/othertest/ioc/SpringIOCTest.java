package com.zhao.othertest.ioc;

import com.zhao.othertest.bean.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringIOCTest {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();

        configApplicationContext.refresh();

        configApplicationContext.register(User.class);
        Object user = configApplicationContext.getBean("user");
        System.out.println(user);
    }
}
