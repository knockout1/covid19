package org.knockout.covid19;

import org.knockout.covid19.collector.StatisticUpdater;
import org.knockout.covid19.collector.WikiStatisticUpdater;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    StatisticUpdater getStatisticUpdater() {
        return new WikiStatisticUpdater("https://en.wikipedia" +
                ".org/wiki/2020_coronavirus_pandemic_in_Poland");
    }
}
