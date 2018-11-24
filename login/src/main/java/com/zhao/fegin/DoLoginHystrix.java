package com.zhao.fegin;

import org.springframework.stereotype.Component;

@Component
public class DoLoginHystrix implements DoLoginService {
    @Override
    public String doLogin(String username, String password) {
        return "fegin-error";
    }
}
