package org.knockout.covid19.controller;

import org.junit.jupiter.api.Test;
import org.knockout.covid19.service.StatisticProviderService;
import org.knockout.covid19.service.StatisticUpdateService;
import org.springframework.http.ResponseEntity;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class StatisticsControllerTest {
    StatisticUpdateService statisticUpdateService = mock(StatisticUpdateService.class);
    StatisticProviderService statisticProviderService = mock(StatisticProviderService.class);
    StatisticsController statisticsController = new StatisticsController(statisticUpdateService,
            statisticProviderService);

    @Test
    void getDailyStatsShouldReturnOK() {
        assertThat(statisticsController.getDailyStats(new Date())).isEqualTo(ResponseEntity.ok().build());
    }

    @Test
    void forceUpdateShouldReturnOk() {
        assertThat(statisticsController.forceUpdate()).isEqualTo(ResponseEntity.ok("Update " +
                "forced"));
    }
}