package com.iiitb.poshak.logging;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class LoggingFilterRequest {
    private List<String> emails;
    private boolean today;
    private boolean lastMonth;
    private boolean lastWeek;
    private boolean lastYear;

    //custom filter between two time in millis
    private Long startTime;
    private Long endTime;
}
