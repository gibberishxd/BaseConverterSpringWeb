package com.example.s27236tpo051.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Controller
public class MyController {

    @GetMapping(path = "/current-time")
    @ResponseBody
    public String current_time(@RequestParam(value ="time-zone", required = false) String time_zone, @RequestParam(value = "time-display", required = false) String time_display, @RequestParam(value = "year-display", required = false) String year_display) {
        LocalDate year;
        LocalTime time;
        ZoneId z = ZoneId.systemDefault();

        DateTimeFormatter time_formatter = DateTimeFormatter.ofPattern(Objects.requireNonNullElse(time_display, "HH:mm:ss.SSSS"));
        DateTimeFormatter year_formatter = DateTimeFormatter.ofPattern(Objects.requireNonNullElse(year_display, "yyyy-MM-dd"));

        time = ZonedDateTime.of(LocalDate.now(), LocalTime.now(), z).toLocalTime();
        year = java.time.LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());

        String time_formatted;
        String year_formatted;

        if (time_zone != null){
            z = ZoneId.of(time_zone);
            ZonedDateTime zoned_time = ZonedDateTime.of(year, time, ZoneId.systemDefault()).withZoneSameInstant(z);
            time_formatted = zoned_time.format(time_formatter);
            year_formatted = zoned_time.format(year_formatter);
        } else {
            time_formatted = time.format(time_formatter);
            year_formatted = year.format(year_formatter);
        }


        return "<h2>Time Zone: " + z + "<br>Time now is: " + time_formatted + "<br>" + "<br>" + "The date today is: " + year_formatted + "</h2>";
    }

    @GetMapping(path = "/current-year")
    @ResponseBody
    public String current_year() {
        return "<h2>The current year is: " + java.time.LocalDate.now().getYear() + "</h2>";
    }
}
