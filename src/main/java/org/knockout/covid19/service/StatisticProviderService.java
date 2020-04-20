package org.knockout.covid19.service;

import org.knockout.covid19.model.DailyStats;
import org.knockout.covid19.repository.StatsRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StatisticProviderService {
    private final StatsRepository statsRepository;

    public StatisticProviderService(StatsRepository statsRepository) {
        this.statsRepository = statsRepository;
    }

    public DailyStats getDailyStats(Date date) {
        return statsRepository.findByDate(date);
    }
}
