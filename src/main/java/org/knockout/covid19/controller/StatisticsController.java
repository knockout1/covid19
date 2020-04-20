package org.knockout.covid19.controller;

import org.knockout.covid19.model.DailyStats;
import org.knockout.covid19.service.StatisticProviderService;
import org.knockout.covid19.service.StatisticUpdateService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping(value = "/getDailyStats/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DailyStats> getDailyStats(@PathVariable @DateTimeFormat(pattern =
            "dd-MM-yyyy") Date date) {
        DailyStats dailyStats = statisticProviderService.getDailyStats(date);
        return ResponseEntity.ok(dailyStats);
    }

    @GetMapping(value = "/forceUpdate")
    public ResponseEntity<String> forceUpdate() {
        statisticUpdateService.forceUpdate();
        return ResponseEntity.ok("Update forced");
    }
}
