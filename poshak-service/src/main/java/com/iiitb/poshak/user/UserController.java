package com.iiitb.poshak.user;

import com.iiitb.poshak.util.ErrorDto;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @ExceptionHandler(Exception.class)
    public ErrorDto handleException(Exception e) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.getError().add(e.getMessage());
        errorDto.setExceptionId("IE-" + System.currentTimeMillis());
        return errorDto;
    }

    @PutMapping(value = "/user/login")
    public User getUser(@RequestBody UserRequest userRequest) throws Exception {
        User users = userService.getUser(userRequest);
        return users;
    }

    @PutMapping(value = "/user/signup")
    public User updateUser(@RequestBody UserRequest userRequest) throws Exception {
        User users = userService.updateUser(userRequest);
        return users;
    }

    @GetMapping(value = "/user/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

}
