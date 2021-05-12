package com.iiitb.poshak.trainer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TrainerControllerTest {

    @InjectMocks
    private TrainerController underTest;

    @Mock
    private TrainerService trainerService;

    @Test
    public void getTrainerGoals() throws Exception {

    }

}