package com.example.MerchantService.feignclient;


import com.example.MerchantService.domain.JwtToken;
import com.example.MerchantService.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "LoginService", url = "http://localhost:9091/")
public interface LoginClient {

    @PostMapping("/user/signup/{roleId}")
    public JwtToken signup(@RequestBody User user, @PathVariable("roleId") int roleId);


}
