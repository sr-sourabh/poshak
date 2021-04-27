package com.iiitb.poshak.trainer;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TrainerGetRequest {
    private String trainerEmail;
    private String userEmail;
}
