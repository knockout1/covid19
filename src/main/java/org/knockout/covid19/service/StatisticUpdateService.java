package org.knockout.covid19.service;

import org.knockout.covid19.collector.StatisticCollector;
import org.knockout.covid19.model.DailyStats;
import org.knockout.covid19.model.StatsBackup;
import org.knockout.covid19.repository.StatsBackupRepository;
import org.knockout.covid19.repository.StatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class StatisticUpdateService {
    private final StatisticCollector statisticCollector;
    private final StatsRepository statsRepository;
    private final StatsBackupRepository statsBackupRepository;

    @Autowired
    public StatisticUpdateService(StatisticCollector statisticCollector,
                                  StatsRepository statsRepository,
                                  StatsBackupRepository statsBackupRepository) {
        this.statisticCollector = statisticCollector;
        this.statsRepository = statsRepository;
        this.statsBackupRepository = statsBackupRepository;
    }

    @Scheduled(cron = "0 0 10,20 * * *")
    public void forceUpdate() {
        System.out.println("update started");
        List<DailyStats> dailyStats = statisticCollector.getStatistic();
        List<DailyStats> currentStats = statsRepository.findAll();
        for (DailyStats dailyStat : currentStats) {
            statsBackupRepository.save(dailyStatsToStatsBackup(dailyStat));
        }
        statsRepository.deleteAll();
        statsRepository.saveAll(dailyStats);
    }

    private StatsBackup dailyStatsToStatsBackup(DailyStats dailyStats) {
        StatsBackup statsBackup = new StatsBackup();
        statsBackup.setConfirmedDaily(dailyStats.getConfirmedDaily());
        statsBackup.setDate(dailyStats.getDate());
        statsBackup.setMonitored(dailyStats.getMonitored());
        statsBackup.setOfficialDeathsDaily(dailyStats.getOfficialDeathsDaily());
        statsBackup.setMonitored(dailyStats.getMonitored());
        statsBackup.setQuarantined(dailyStats.getQuarantined());
        statsBackup.setRecovered(dailyStats.getRecovered());
        statsBackup.setSuspected(dailyStats.getSuspected());
        statsBackup.setTotalTested(dailyStats.getTotalTested());
        statsBackup.setUnofficialDeathsDaily(dailyStats.getUnofficialDeathsDaily());
        statsBackup.setUpToDateConfirmed(dailyStats.getUpToDateConfirmed());
        statsBackup.setStatsBackupDate(Date.from(Instant.now()));
        return statsBackup;
    }
}
