package org.knockout.covid19.service;

import org.junit.jupiter.api.Test;
import org.knockout.covid19.collector.StatisticUpdater;

import static org.mockito.Mockito.mock;

class StatisticUpdateServiceTest {
    StatisticUpdater statisticUpdater = mock(StatisticUpdater.class);
    StatisticUpdateService statisticUpdateService = new StatisticUpdateService(statisticUpdater);

    @Test
    void forceUpdate() {
        statisticUpdateService.forceUpdate();
    }
}