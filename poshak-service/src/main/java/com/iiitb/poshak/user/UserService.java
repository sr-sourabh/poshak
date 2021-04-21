package com.iiitb.poshak.user;

import com.iiitb.poshak.logging.Logging;
import com.iiitb.poshak.logging.LoggingRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    @Resource
    private LoggingRepository loggingRepository;

    public User getUser(UserRequest userRequest) throws Exception {
        if (Strings.isBlank(userRequest.getPassword())) {
            throw new Exception("Password cannot be empty");
        }

        String pass = DigestUtils.sha384Hex(userRequest.getPassword());
        User user = userRepository.findAllByEmailIdAndPassword(userRequest.getEmailId(), pass);

        if (Objects.isNull(user)) {
            throw new Exception("User not found");
        }

        return user;
    }

    @Transactional
    public User updateUser(UserRequest userRequest) throws Exception {

        User user = userRepository.findByEmailId(userRequest.getEmailId());

        if (Objects.isNull(user)) {
            user = new User();
            if (Strings.isBlank(userRequest.getPassword())) {
                throw new Exception("Password cannot be empty");
            }
            String pass = DigestUtils.sha384Hex(userRequest.getPassword());
            user.setPassword(pass);
            user.setEmailId(userRequest.getEmailId());

            Logging logging = new Logging();
            logging.setEmail(userRequest.getEmailId());
            loggingRepository.save(logging);

            user.setStatus(1);
        }

        if (Strings.isNotBlank(userRequest.getName())) {
            user.setName(userRequest.getName());
        }
        if (Objects.nonNull(userRequest.getHeight())) {
            user.setHeight(userRequest.getHeight());
        }
        if (Objects.nonNull(userRequest.getWeight())) {
            user.setWeight(userRequest.getWeight());
        }
        if (Objects.nonNull(userRequest.getCalorieGoal())) {
            user.setCalorieGoal(userRequest.getCalorieGoal());
        }
        if (Objects.nonNull(userRequest.getCarbsGoal())) {
            user.setCarbsGoal(userRequest.getCarbsGoal());
        }
        if (Objects.nonNull(userRequest.getFatGoal())) {
            user.setFatGoal(userRequest.getFatGoal());
        }
        if (Objects.nonNull(userRequest.getProteinGoal())) {
            user.setProteinGoal(userRequest.getProteinGoal());
        }

        return userRepository.save(user);
    }

}



