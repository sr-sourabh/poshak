package com.iiitb.poshak.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SequenceTest {

    @Test
    public void test() {
        Sequence sequence = new Sequence();
        sequence.setId("22");
        sequence.setSequenceName("22");
        sequence.setNextval(22L);

        Assertions.assertEquals("22", sequence.getSequenceName());
        Assertions.assertEquals("22", sequence.getId());
        Assertions.assertEquals(22L, sequence.getNextval());
        Assertions.assertEquals(hashCode(sequence), sequence.hashCode());
        Assertions.assertEquals(toString(sequence), sequence.toString());
    }

    public int hashCode(Sequence sequence) {
        int result = 1;
        Object $nextval = sequence.getNextval();
        result = result * 59 + ($nextval == null ? 43 : $nextval.hashCode());
        Object $id = sequence.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $sequenceName = sequence.getSequenceName();
        result = result * 59 + ($sequenceName == null ? 43 : $sequenceName.hashCode());
        return result;
    }

    public String toString(Sequence sequence) {
        return "Sequence(id=" + sequence.getId() + ", sequenceName=" + sequence.getSequenceName() + ", nextval=" + sequence.getNextval() + ")";
    }
}