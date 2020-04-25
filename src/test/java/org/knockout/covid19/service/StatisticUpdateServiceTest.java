package org.knockout.covid19.service;

import org.junit.jupiter.api.Test;
import org.knockout.covid19.collector.StatisticCollector;
import org.knockout.covid19.repository.StatsBackupRepository;
import org.knockout.covid19.repository.StatsRepository;

import static org.mockito.Mockito.mock;

class StatisticUpdateServiceTest {
    StatisticCollector statisticCollector = mock(StatisticCollector.class);
    StatsRepository statsRepository = mock(StatsRepository.class);
    StatsBackupRepository statsBackupRepository = mock(StatsBackupRepository.class);
    StatisticUpdateService statisticUpdateService = new StatisticUpdateService(statisticCollector,
            statsRepository, statsBackupRepository);

    @Test
    void forceUpdate() {
        statisticUpdateService.forceUpdate();
    }
}