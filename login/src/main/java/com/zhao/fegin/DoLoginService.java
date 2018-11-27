package com.zhao.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-service", fallback = DoLoginHystrix.class)
public interface DoLoginService {

    @GetMapping("/s/dologin")
    public String doLogin(@RequestParam("username") String username, @RequestParam("password") String password);
}
