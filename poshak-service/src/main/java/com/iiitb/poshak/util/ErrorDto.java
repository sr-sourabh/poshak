package com.iiitb.poshak.util;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ErrorDto {
    private List<String> error = new ArrayList<>();
}
