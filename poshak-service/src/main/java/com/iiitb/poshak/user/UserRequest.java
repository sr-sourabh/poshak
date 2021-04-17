package com.iiitb.poshak.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequest {

    private String emailId;
    private String password;
    private String name;
    private int status;
    private int height;
    private int weight;

}
