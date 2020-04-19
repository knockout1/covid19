package org.knockout.covid19.repository;

import org.knockout.covid19.model.DailyStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatsRepository extends JpaRepository<DailyStats, Long> {
}
