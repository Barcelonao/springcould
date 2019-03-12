package com.zhao.othertest.controller;

import com.zhao.othertest.bean.User;
import com.zhao.othertest.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.RequestWrapper;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "hello")
public class HelloworldController {

    @Autowired
    HelloWorldService helloWorldService;

    @RequestMapping("world")
    public void helloworld() {
        System.out.println("controller开始执行");
        helloWorldService.test();
        System.out.println("controller 已返回");
    }

    @PostMapping(value = "test",produces = MediaType.APPLICATION_JSON_VALUE)
    public void testVaild(@RequestBody @Valid User user){
        System.out.println(user);
    }


    @GetMapping(value = "test2")
    public void testGet(@Valid User user, @RequestParam("list[]")ArrayList<Long> list){
        System.out.println(user);
    }
}
