package org.knockout.covid19.collector;

import org.knockout.covid19.model.DailyStats;

import java.util.List;

public interface StatisticCollector {
    List<DailyStats> getStatistic();
}
