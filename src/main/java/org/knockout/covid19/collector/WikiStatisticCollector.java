package org.knockout.covid19.collector;

import com.google.common.primitives.Ints;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.knockout.covid19.model.DailyStats;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WikiStatisticCollector implements StatisticCollector {
    private final String url;
    private final int connectionTimeoutMs = 10000;

    public WikiStatisticCollector(String url) {
        this.url = url;
    }

    @Override
    public List<DailyStats> getStatistic() {
        List<DailyStats> dailyStats = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url)
                    .data("query", "Java")
                    .userAgent("Mozilla")
                    .timeout(connectionTimeoutMs)
                    .get();
            Element table = doc.select("table[class=wikitable sortable mw-collapsible " +
                    "floatright]").first();
            Elements rows = table.select("tr");
            SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
            for (Element row : rows) {
                Elements columns = row.select("td");
                if (!isTableHeaderOrFooter(columns)) {
                    DailyStats dailyStat = new DailyStats();
                    dailyStat.setDate(formatter.parse(columns.get(0).text()));
                    dailyStat.setSuspected(Optional.ofNullable(columns.get(1).text()).map(Ints::tryParse).orElse(0));
                    dailyStat.setQuarantined(Optional.ofNullable(columns.get(2).text()).map(Ints::tryParse).orElse(0));
                    dailyStat.setMonitored(Optional.ofNullable(columns.get(3).text()).map(Ints::tryParse).orElse(0));
                    dailyStat.setTotalTested(Optional.ofNullable(columns.get(4).text()).map(Ints::tryParse).orElse(0));
                    dailyStat.setConfirmedDaily(Optional.ofNullable(columns.get(5).text()).map(Ints::tryParse).orElse(0));
                    dailyStat.setUpToDateConfirmed(Optional.ofNullable(columns.get(6).text()).map(Ints::tryParse).orElse(0));
                    dailyStat.setRecovered(Optional.ofNullable(columns.get(7).text()).map(Ints::tryParse).orElse(0));
                    dailyStat.setOfficialDeathsDaily(Optional.ofNullable(columns.get(8).text()).map(Ints::tryParse).orElse(0));
                    dailyStat.setUnofficialDeathsDaily(Optional.ofNullable(columns.get(9).text()).map(Ints::tryParse).orElse(0));
                    dailyStats.add(dailyStat);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return dailyStats;
    }

    private boolean isTableHeaderOrFooter(Elements row) {
        return (row.size() < 10 || row.get(0).text().equals("Total"));
    }
}
