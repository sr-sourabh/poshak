package com.iiitb.poshak.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping(value = "/user")
    public List<User> getUser() {
        return userService.getUser("ayush");
    }

}
