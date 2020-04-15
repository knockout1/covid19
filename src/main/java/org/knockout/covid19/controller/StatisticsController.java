package org.knockout.covid19.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController (value = "statistics")
public class StatisticsController {

    @GetMapping(value = "/getDailyStats", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> getDailyStats(Date date) {
        return ResponseEntity.ok().build();
    }
}
