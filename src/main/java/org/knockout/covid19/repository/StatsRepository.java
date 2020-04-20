package org.knockout.covid19.repository;

import org.knockout.covid19.model.DailyStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface StatsRepository extends JpaRepository<DailyStats, Long> {
    DailyStats findByDate(Date date);
}
