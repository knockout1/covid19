package org.knockout.covid19.collector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Iterator;

public class WikiStatisticUpdater implements StatisticUpdater {
    private final String url;
    private final int connectionTimeoutMs = 10000;

    public WikiStatisticUpdater(String url) {
        this.url = url;
    }

    @Override
    public void updateStatistic() {
        try {
            Document doc = Jsoup.connect(url)
                    .data("query", "Java")
                    .userAgent("Mozilla")
                    .timeout(connectionTimeoutMs)
                    .get();
            Element table = doc.select("table[class=wikitable sortable mw-collapsible " +
                    "floatright]").first();
//            Iterator<Element> ite = table.select("td[width=65]").iterator();
//            ite.next().text();
            System.out.println(table);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
