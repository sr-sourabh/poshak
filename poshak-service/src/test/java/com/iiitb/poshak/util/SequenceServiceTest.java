package com.iiitb.poshak.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoOperations;

@ExtendWith(MockitoExtension.class)
class SequenceServiceTest {

    @InjectMocks
    private SequenceService sequenceService;

    @Mock
    private MongoOperations mongoOperations;

    @Mock
    private Sequence sequence;


    @Test
    public void test() {
        String sequenceName = "22";
        Class<Sequence> sequenceClass = Mockito.any();
        Mockito.when(mongoOperations.findAndModify(
                Mockito.any(),
                Mockito.any(),
                Mockito.any(),
                sequenceClass)).thenReturn(sequence);
        sequenceService.getSequenceNextVal(sequenceName);
    }

}