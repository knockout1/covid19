package org.knockout.covid19.collector;

import com.google.common.primitives.Ints;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.knockout.covid19.model.DailyStats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WikiStatisticCollector implements StatisticCollector {
    private static final Logger LOGGER = LoggerFactory.getLogger(WikiStatisticCollector.class);
    private final String url;

    public WikiStatisticCollector(String url) {
        this.url = url;
    }

    @Override
    public List<DailyStats> getStatistic() {
        List<DailyStats> dailyStats = new ArrayList<>();
        try {
            int connectionTimeoutMs = 10000;
            Document doc =
                    Jsoup.connect(url).userAgent("Mozilla").timeout(connectionTimeoutMs).get();
            Element table = doc.select("table[class=wikitable sortable mw-collapsible " +
                    "floatright]").first();
            Elements rows = table.select("tr");
            SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
            for (Element row : rows) {
                Elements columns = row.select("td");
                if (!isTableHeaderOrFooter(columns)) {
                    DailyStats dailyStat = new DailyStats();
                    dailyStat.setDate(formatter.parse(columns.get(0).text()));
                    dailyStat.setSuspected(parseCell(columns.get(1).text()));
                    dailyStat.setQuarantined(parseCell(columns.get(2).text()));
                    dailyStat.setMonitored(parseCell(columns.get(3).text()));
                    dailyStat.setTotalTested(parseCell(columns.get(4).text()));
                    dailyStat.setConfirmedDaily(parseCell(columns.get(5).text()));
                    dailyStat.setUpToDateConfirmed(parseCell(columns.get(6).text()));
                    dailyStat.setRecovered(parseCell(columns.get(7).text()));
                    dailyStat.setOfficialDeathsDaily(parseCell(columns.get(8).text()));
                    dailyStat.setUnofficialDeathsDaily(parseCell(columns.get(9).text()));
                    dailyStats.add(dailyStat);
                }
            }
        } catch (IOException | ParseException e) {
            LOGGER.warn("Error parsing  statistics: {}", e.getMessage());
        }
        return dailyStats;
    }

    private boolean isTableHeaderOrFooter(Elements row) {
        return (row.size() < 10 || row.get(0).text().equals("Total"));
    }

    private int parseCell(String cell) {
        cell = cell.replace(",", "");
        if (cell.contains("[")) {
            cell = cell.substring(0, cell.indexOf("["));
        }
        return Optional.of(cell).map(Ints::tryParse).orElse(0);
    }
}
