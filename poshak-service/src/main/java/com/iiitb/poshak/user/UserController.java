package com.iiitb.poshak.user;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PutMapping(value = "/user/login")
    public User getUser(@RequestBody UserRequest userRequest) {
        User users = userService.getUser(userRequest);
        return users;
    }

    @PutMapping(value = "/user/signup")
    public User setUser(@RequestBody UserRequest userRequest) {
        User users = userService.setUser(userRequest);
        return users;
    }

}
