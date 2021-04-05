package com.iiitb.poshak.user;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public List<User> getUser(String name) {
        return userRepository.findAllByName(name);
    }

}
