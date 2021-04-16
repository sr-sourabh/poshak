package com.iiitb.poshak.user;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public User getUser(UserRequest userRequest) {
        return userRepository.findAllByEmailIdAndPassword(userRequest.getEmailId(), userRequest.getPassword());
    }

    public User setUser(UserRequest userRequest) {
        User user = new User();
        user.setEmailId(userRequest.getEmailId());
        user.setPassword(userRequest.getPassword());
        user.setStatus(1);

        return userRepository.save(user);
    }

}
