package com.iiitb.poshak.user;

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

    @Test
    public void getUser() throws Exception {
        UserRequest userRequest = new UserRequest();
        userRequest.setPassword("MyPassword");
        userRequest.setEmailId("email@email.com");

        User user = new User();

        Mockito.when(userRepository.findAllByEmailIdAndPassword(Mockito.anyString(), Mockito.anyString())).thenReturn(user);

        User result = underTest.getUser(userRequest);

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

        User user = new User();

        Mockito.when(userRepository.findByEmailId(userRequest.getEmailId())).thenReturn(user);
        Mockito.when(userRepository.save(user)).thenReturn(user);

        User result = underTest.updateUser(userRequest);

        Assertions.assertEquals(user, result);

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
