DROP TABLE IF EXISTS stats;
CREATE TABLE stats (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  date DATE NOT NULL,
  suspected INT NOT NULL,
  quarantined INT NOT NULL,
  monitored INT NOT NULL,
  totalTested INT NOT NULL,
  confirmedDaily INT NOT NULL,
  upToDateConfirmed INT NOT NULL,
  recovered INT NOT NULL,
  officialDeathsDaily INT NOT NULL,
  unofficialDeathsDaily INT NOT NULL
);

CREATE TABLE statsBackup(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  date DATE NOT NULL,
  suspected INT NOT NULL,
  quarantined INT NOT NULL,
  monitored INT NOT NULL,
  totalTested INT NOT NULL,
  confirmedDaily INT NOT NULL,
  upToDateConfirmed INT NOT NULL,
  recovered INT NOT NULL,
  officialDeathsDaily INT NOT NULL,
  unofficialDeathsDaily INT NOT NULL
)