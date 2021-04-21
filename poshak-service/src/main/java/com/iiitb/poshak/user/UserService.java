package com.iiitb.poshak.user;

import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public User getUser(UserRequest userRequest) {
        String pass = DigestUtils.sha384Hex(userRequest.getPassword());

        return userRepository.findAllByEmailIdAndPassword(userRequest.getEmailId(), pass);
    }

    public User setUser(UserRequest userRequest) {
        User user = new User();
        user.setEmailId(userRequest.getEmailId());
        String pass = DigestUtils.sha384Hex(userRequest.getPassword());
        user.setPassword(pass);
        user.setStatus(1);
        user.setName(userRequest.getName());
        user.setHeight(userRequest.getHeight());
        user.setWeight(userRequest.getWeight());


        return userRepository.save(user);
    }

}



