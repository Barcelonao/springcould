package com.zhao.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhao.fegin.DoLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DoLoginController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DoLoginService doLoginService;


    @GetMapping("/dologin")
    //@HystrixCommand(fallbackMethod = "doLoginFallback")
    public String DoLogin() {

//        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://compute-service/s/dologin?username=zhao&password=123456", String.class);
//
//        return forEntity.getBody();

        return doLoginService.doLogin("xixii", "hahaha");
    }

    public String doLoginFallback() {

        return "error";
    }
}
