package org.exadel.bsu.tasks.second.midtest.text.processors;

import com.google.common.base.Function;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * @author skrauchenia
 */
@Component("mostPopularTextProcessor")
public class MostPopularTextProcessor implements TextProcessor<List<String>> {

    @Value("#{properties.chartCapacity}")
    private int chartCapacity = 5;

    @Override
    @Cacheable("most-popular-text-processor-cache")
    public List<String> process(String text) {
        String[] words = text.split("\\s");
        Multiset<String> wordsCount = HashMultiset.create();
        for (String word : words) {
            wordsCount.add(word.toLowerCase());
        }

        List<Multiset.Entry<String>> entries = sortWordsCounts(wordsCount.entrySet());

        return getMostPopular(entries);
    }

    private List<String> getMostPopular(List<Multiset.Entry<String>> entries) {
        List<String> words = Lists.transform(entries, new Function<Multiset.Entry<String>, String>() {
            @Override
            public String apply(Multiset.Entry<String> entry) {
                return entry.getElement();
            }
        });
        return words.size() > chartCapacity ? words.subList(0, chartCapacity) : words;
    }

    private List<Multiset.Entry<String>> sortWordsCounts(Set<Multiset.Entry<String>> entries) {
        List<Multiset.Entry<String>> sortedWords = Lists.newArrayList(entries);
        Collections.sort(sortedWords, new Comparator<Multiset.Entry<String>>() {

            @Override
            public int compare(Multiset.Entry<String> o1, Multiset.Entry<String> o2) {
                return ComparisonChain.start()
                        .compare(o2.getCount(), o1.getCount())
                        .compare(o1.getElement(), o2.getElement())
                        .result();
            }
        });

        return sortedWords;
    }
}
