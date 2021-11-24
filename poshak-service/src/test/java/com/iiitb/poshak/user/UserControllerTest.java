package com.iiitb.poshak.user;

import com.iiitb.poshak.util.ErrorDto;
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

    @Test
    public void getAllUsers() throws Exception {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setEmailId("dave@gmail.com");
        user.setName("dave");
        users.add(user);
        Mockito.when(userService.getAllUsers()).thenReturn(users);
        List<User> results = underTest.getAllUsers();
        Assertions.assertEquals(users, results);
    }

    @Test
    public void handleException() {
        ErrorDto expected = new ErrorDto();
        String message = "IE-332";
        Exception exception = new Exception(message);
        expected.getError().add(exception.getMessage());

        ErrorDto result = underTest.handleException(exception);
        Assertions.assertEquals(result.getError().get(0), expected.getError().get(0));
        Assertions.assertNotNull(result.getExceptionId());
    }

}