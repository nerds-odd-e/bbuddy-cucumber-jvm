package com.odde.cucumber;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "usersClient", url = "http://localhost:8080")
public interface UsersClient {

    @PostMapping("/users/signup")
    void signUp(User user);

    @PostMapping("/login")
    Response signIn(User user);
}
