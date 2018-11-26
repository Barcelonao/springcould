package com.zhao.othertest.controller;

import com.zhao.othertest.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.RequestWrapper;

@Controller
@RequestMapping("hello")
public class HelloworldController {

    @Autowired
    HelloWorldService helloWorldService;

    @RequestMapping("world")
    public void helloworld() {
        System.out.println("controller开始执行");
        helloWorldService.test();
        System.out.println("controller 已返回");
    }
}
