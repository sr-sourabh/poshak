package com.iiitb.poshak.logging;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "logging")
public class Logging {

    @Id
    private String id;

    @Field(name = "email_id")
    private String email;


    @Field(name = "log")
    private List<Log> log = new ArrayList<>();
}
