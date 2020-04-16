package org.knockout.covid19.controller;

import org.knockout.covid19.service.StatisticProviderService;
import org.knockout.covid19.service.StatisticUpdateService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/statistics")
public class StatisticsController {
    private final StatisticUpdateService statisticUpdateService;
    private final StatisticProviderService statisticProviderService;

    public StatisticsController(StatisticUpdateService statisticUpdateService,
                                StatisticProviderService statisticProviderService) {
        this.statisticUpdateService = statisticUpdateService;
        this.statisticProviderService = statisticProviderService;
    }

    @GetMapping(value = "/getDailyStats", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> getDailyStats(Date date) {
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/forceUpdate")
    public ResponseEntity<String> forceUpdate() {
        statisticUpdateService.forceUpdate();
        return ResponseEntity.ok("Update forced");
    }
}
