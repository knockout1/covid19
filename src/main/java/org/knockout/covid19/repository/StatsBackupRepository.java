package org.knockout.covid19.repository;

import org.knockout.covid19.model.StatsBackup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatsBackupRepository extends JpaRepository<StatsBackup, Long> {
}