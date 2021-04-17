package com.iiitb.poshak.user;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
