package org.exadel.bsu.tasks.second.midtest.text.processors;

import com.google.common.collect.ImmutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author skrauchenia
 */
@Component("mostPopularTextProcessor")
public class MostPopularTextProcessor implements TextProcessor<List<String>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MostPopularTextProcessor.class);

    @Value("#{properties.chartCapacity}")
    private int chartCapacity;

    @Override
    @Cacheable("most-popular-text-processor-cache")
    public List<String> process(String textFileName) {
        LOGGER.info("Processing text from {}", textFileName);
        return ImmutableList.of();
    }
}
