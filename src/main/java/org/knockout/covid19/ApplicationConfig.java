package org.knockout.covid19;

import org.knockout.covid19.collector.StatisticCollector;
import org.knockout.covid19.collector.WikiStatisticCollector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@Configuration
public class ApplicationConfig {
    @Bean
    StatisticCollector getStatisticUpdater() {
        return new WikiStatisticCollector("https://en.wikipedia" +
                ".org/wiki/2020_coronavirus_pandemic_in_Poland");
    }
}
