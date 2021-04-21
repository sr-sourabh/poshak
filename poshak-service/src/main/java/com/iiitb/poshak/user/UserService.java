package com.iiitb.poshak.user;

import com.iiitb.poshak.logging.Logging;
import com.iiitb.poshak.logging.LoggingRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    @Resource
    private LoggingRepository loggingRepository;

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

        Logging logging = new Logging();
        logging.setEmail(userRequest.getEmailId());
        loggingRepository.save(logging);

        return userRepository.save(user);
    }

}



