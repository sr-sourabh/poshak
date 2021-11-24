package com.iiitb.poshak.user;

import com.iiitb.poshak.logging.LoggingRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService underTest;

    @Mock
    private UserRepository userRepository;

    @Mock
    private LoggingRepository loggingRepository;

    @Test
    public void getUser() {
        UserRequest userRequest = new UserRequest();
        userRequest.setPassword("MyPassword");
        userRequest.setEmailId("email@email.com");

        User user = new User();

        Mockito.when(userRepository.findAllByEmailIdAndPassword(Mockito.anyString(), Mockito.anyString())).thenReturn(user);
        User result = null;
        try {
            result = underTest.getUser(userRequest);
        } catch (Exception e) {
            Assertions.fail();
        }
        Assertions.assertNotNull(result);
        Assertions.assertEquals(user, result);
    }


    @Test
    public void getUser_negativeTestCase_throws_exception() {
        UserRequest userRequest = new UserRequest();
        userRequest.setPassword(null);
        try {
            underTest.getUser(userRequest);
        } catch (Exception e) {
            Assertions.assertNotNull(e);
            Assertions.assertEquals(e.getClass(), Exception.class);
            Assertions.assertEquals("Password cannot be empty", e.getMessage());
        }
    }

    @Test
    public void updateUser() throws Exception {
        UserRequest userRequest = new UserRequest();
        userRequest.setEmailId("email");
        userRequest.setPassword("MyPassword");
        userRequest.setHeight(22);
        userRequest.setName("Alpha");
        userRequest.setWeight(22);
        userRequest.setCalorieGoal(22f);
        userRequest.setCarbsGoal(44f);
        userRequest.setFatGoal(11f);
        userRequest.setProteinGoal(453f);

        User user = new User();
        user.setEmailId("email");
        user.setPassword("MyPassword");
        user.setHeight(22);
        user.setName("Alpha");
        user.setWeight(22);
        user.setCalorieGoal(22f);
        user.setCarbsGoal(44f);
        user.setFatGoal(11f);
        user.setProteinGoal(453f);

        User userToReturn = new User();
        userToReturn.setEmailId(user.getEmailId());
        userToReturn.setPassword(user.getPassword());

        Mockito.when(userRepository.findByEmailId(userRequest.getEmailId())).thenReturn(userToReturn);
        Mockito.when(userRepository.save(userToReturn)).thenReturn(userToReturn);

        User result = underTest.updateUser(userRequest);

        Assertions.assertEquals(user, result);

    }

    @Test
    public void updateUserBlank() throws Exception {
        UserRequest userRequest = new UserRequest();
        userRequest.setEmailId("email");
        userRequest.setPassword("MyPassword");
        userRequest.setHeight(22);
        userRequest.setName("Alpha");
        userRequest.setWeight(22);
        userRequest.setCalorieGoal(22f);
        userRequest.setCarbsGoal(44f);
        userRequest.setFatGoal(11f);
        userRequest.setProteinGoal(453f);

        User user = new User();
        user.setEmailId("email");
        user.setPassword("MyPassword");
        user.setHeight(22);
        user.setName("Alpha");
        user.setWeight(22);
        user.setCalorieGoal(22f);
        user.setCarbsGoal(44f);
        user.setFatGoal(11f);
        user.setProteinGoal(453f);

        User userToReturn = new User();
        userToReturn.setEmailId(user.getEmailId());
        userToReturn.setPassword(DigestUtils.sha384Hex(userRequest.getPassword()));

        Mockito.when(userRepository.save(Mockito.any())).thenReturn(userToReturn);
        Mockito.when(loggingRepository.save(Mockito.any())).thenReturn(null);

        User result = underTest.updateUser(userRequest);

        Assertions.assertEquals(DigestUtils.sha384Hex(userRequest.getPassword()), result.getPassword());

    }

    @Test
    public void updateUserBlankPasswordBlank() throws Exception {
        UserRequest userRequest = new UserRequest();
        userRequest.setEmailId("email");
        userRequest.setHeight(22);
        userRequest.setName("Alpha");
        userRequest.setWeight(22);
        userRequest.setCalorieGoal(22f);
        userRequest.setCarbsGoal(44f);
        userRequest.setFatGoal(11f);
        userRequest.setProteinGoal(453f);

        User user = new User();

        User result = null;
        try {
            result = underTest.updateUser(userRequest);
        } catch (Exception e) {
            Assertions.assertEquals("Password cannot be empty", e.getMessage());
        }

    }

    @Test
    public void getAllUsers() {
        List<User> users = new ArrayList<>();
        User user = new User();
        users.add(user);

        Mockito.when(userRepository.findAll()).thenReturn(users);

        List<User> results = underTest.getAllUsers();

        Assertions.assertEquals(users, results);
    }

}
