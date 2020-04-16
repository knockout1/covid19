package org.knockout.covid19.service;

import org.knockout.covid19.collector.StatisticUpdater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticUpdateService {

    private final StatisticUpdater statisticUpdater;

    @Autowired
    public StatisticUpdateService(StatisticUpdater statisticUpdater) {
        this.statisticUpdater = statisticUpdater;
    }

    public void forceUpdate() {
        statisticUpdater.updateStatistic();
    }
}
