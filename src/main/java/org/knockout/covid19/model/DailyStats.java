package org.knockout.covid19.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.StringJoiner;

@Entity
public class DailyStats {
    @Id
    @GeneratedValue
    int id;
    Date date;
    int suspected;
    int quarantined;
    int monitored;
    int totalTested;
    int confirmedDaily;
    int upToDateConfirmed;
    int recovered;
    int officialDeathsDaily;
    int unofficialDeathsDaily;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSuspected() {
        return suspected;
    }

    public void setSuspected(int suspected) {
        this.suspected = suspected;
    }

    public int getQuarantined() {
        return quarantined;
    }

    public void setQuarantined(int quarantined) {
        this.quarantined = quarantined;
    }

    public int getMonitored() {
        return monitored;
    }

    public void setMonitored(int monitored) {
        this.monitored = monitored;
    }

    public int getTotalTested() {
        return totalTested;
    }

    public void setTotalTested(int totalTested) {
        this.totalTested = totalTested;
    }

    public int getConfirmedDaily() {
        return confirmedDaily;
    }

    public void setConfirmedDaily(int confirmedDaily) {
        this.confirmedDaily = confirmedDaily;
    }

    public int getUpToDateConfirmed() {
        return upToDateConfirmed;
    }

    public void setUpToDateConfirmed(int upToDateConfirmed) {
        this.upToDateConfirmed = upToDateConfirmed;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getOfficialDeathsDaily() {
        return officialDeathsDaily;
    }

    public void setOfficialDeathsDaily(int officialDeathsDaily) {
        this.officialDeathsDaily = officialDeathsDaily;
    }

    public int getUnofficialDeathsDaily() {
        return unofficialDeathsDaily;
    }

    public void setUnofficialDeathsDaily(int unofficialDeathsDaily) {
        this.unofficialDeathsDaily = unofficialDeathsDaily;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DailyStats.class.getSimpleName() + "[", "]")
                .add("date=" + date)
                .add("suspected=" + suspected)
                .add("quarantined=" + quarantined)
                .add("monitored=" + monitored)
                .add("totalTested=" + totalTested)
                .add("confirmedDaily=" + confirmedDaily)
                .add("upToDateConfirmed=" + upToDateConfirmed)
                .add("recovered=" + recovered)
                .add("officialDeathsDaily=" + officialDeathsDaily)
                .add("unofficialDeathsDaily=" + unofficialDeathsDaily)
                .toString();
    }
}
