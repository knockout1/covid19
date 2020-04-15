package org.knockout.covid19.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticsControllerTest {
    StatisticsController statisticsController = new StatisticsController();

    @Test
    void getDailyStatsShouldReturnOK() {
        assertThat(statisticsController.getDailyStats(new Date())).isEqualTo(ResponseEntity.ok().build());
    }
}