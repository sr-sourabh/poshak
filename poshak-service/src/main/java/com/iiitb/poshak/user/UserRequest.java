package com.iiitb.poshak.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequest {

    private String emailId;
    private String password;
}
