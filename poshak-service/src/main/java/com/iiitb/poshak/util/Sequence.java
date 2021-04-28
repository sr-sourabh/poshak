package com.iiitb.poshak.util;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@Document("sequence")
public class Sequence {

    @Id
    private String id;

    @Field(value = "sequenceName")
    private String sequenceName;

    @Field(value = "nextval")
    private Long nextval;
}
