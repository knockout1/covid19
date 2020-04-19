package org.knockout.covid19.service;

import org.knockout.covid19.collector.StatisticCollector;
import org.knockout.covid19.model.DailyStats;
import org.knockout.covid19.repository.StatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticUpdateService {

    private final StatisticCollector statisticCollector;
    private final StatsRepository statsRepository;

    @Autowired
    public StatisticUpdateService(StatisticCollector statisticCollector,
                                  StatsRepository statsRepository) {
        this.statisticCollector = statisticCollector;
        this.statsRepository = statsRepository;
    }

    public void forceUpdate() {
        List<DailyStats> dailyStats = statisticCollector.getStatistic();
        statsRepository.saveAll(dailyStats);
    }
}
