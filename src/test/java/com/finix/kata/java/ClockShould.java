package com.finix.kata.java;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by alex on 7/3/17.
 */
@RunWith(JUnit4.class)
public class ClockShould {
    @Test 
        public void should_return_date_formated_dd_MM_yyyy() {
            Clock clock = new Clock();

            String date = clock.todayAsString();

            assertThat(date, is("03/07/2017"));
    }
}