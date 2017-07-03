package com.finix.kata.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by alex on 6/20/17.
 */
public class Clock {

    public String todayAsString() {
        LocalDate today = LocalDate.now();
        return today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
