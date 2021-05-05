package com.iiitb.poshak.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    private UserController underTest;

    @Mock
    private UserService userService;

    @Test
    public void getUser() throws Exception {
        UserRequest userRequest = new UserRequest();
        userRequest.setEmailId("shourabh@gmail.com");
        userRequest.setPassword("PasswordNonHashed");

        User user = new User();
        user.setEmailId("shourabh@gmail.com");

        Mockito.when(userService.getUser(userRequest)).thenReturn(user);

        User result = underTest.getUser(userRequest);

        Assertions.assertEquals(user, result);
        Assertions.assertEquals("shourabh@gmail.com", user.getEmailId());
    }

    @Test
    public void updateUser() throws Exception {
        UserRequest userRequest = new UserRequest();
        userRequest.setEmailId("shourabh@gmail.com");
        userRequest.setPassword("PasswordNonHashed");

        User user = new User();
        user.setEmailId("shourabh@gmail.com");

        Mockito.when(userService.updateUser(userRequest)).thenReturn(user);

        User result = underTest.updateUser(userRequest);

        Assertions.assertEquals(user, result);
        Assertions.assertEquals("shourabh@gmail.com", user.getEmailId());
    }

}