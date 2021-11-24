package com.iiitb.poshak.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ErrorDtoTest {
    @Test
    public void test() {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setExceptionId("22");
        List<String> error = new ArrayList<>();
        error.add("22");
        errorDto.setError(error);

        Assertions.assertEquals("22", errorDto.getExceptionId());
        Assertions.assertEquals(1, errorDto.getError().size());
        Assertions.assertEquals("22", errorDto.getError().get(0));
        Assertions.assertEquals(hashCode(errorDto), errorDto.hashCode());
        Assertions.assertEquals(toString(errorDto), errorDto.toString());
    }

    public int hashCode(ErrorDto errorDto) {
        int result = 1;
        Object $exceptionId = errorDto.getExceptionId();
        result = result * 59 + ($exceptionId == null ? 43 : $exceptionId.hashCode());
        Object $error = errorDto.getError();
        result = result * 59 + ($error == null ? 43 : $error.hashCode());
        return result;
    }

    public String toString(ErrorDto errorDto) {
        return "ErrorDto(exceptionId=" + errorDto.getExceptionId() + ", error=" + errorDto.getError() + ")";
    }
}