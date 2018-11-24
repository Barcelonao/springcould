package com.zhao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/s/dologin")
    public String doLogin(@RequestParam String username, @RequestParam String password) {

        System.out.println("Username " + username + "Password" + password);
        return "true";
    }
}
