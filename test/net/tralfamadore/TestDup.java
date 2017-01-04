package net.tralfamadore;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

/**
 * Class: TestDup
 * Created by billreh on 12/22/16.
 */
public class TestDup {
    @Test
    public void testDup() throws IOException {
        List<Integer> ints = Arrays.asList(1, 3, 4, 7, 1, 3);
        Set<Integer> uniqueInts = new HashSet<>();
        Set<Integer> dupInts = new HashSet<>();
        for(Integer i : ints) {
            if(!uniqueInts.add(i))
                dupInts.add(i);
        }
        System.out.println("unique ints: " + uniqueInts);
        System.out.println("duplicate ints: " + dupInts);
    }

    @Test
    public void testDupRead() throws Exception {
        List<String> lines = Files.readAllLines(new File("README").toPath());
        List<String> words = new ArrayList<>();
        lines.forEach(line -> words.addAll(Arrays.asList(line.split("\\s+"))));
        words.forEach(word -> word = word.replaceAll("\\W", ""));
        Set<String> uniqueWords = new HashSet<>();
        Map<String,Integer> wordCount = new TreeMap<>();
        words.forEach(word -> {
            if(!word.trim().isEmpty()) {
                if (uniqueWords.add(word))
                    wordCount.put(word, 1);
                else
                    wordCount.replace(word, wordCount.get(word) + 1);
            }
        });
        System.out.println(entriesSortedByValuesDescending(wordCount));
    }

    private static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> entriesSortedByValuesDescending(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<>(
                (e1, e2) -> {
                    int res = e1.getValue().compareTo(e2.getValue());
                    return res != 0 ? -res : 1; // to return in descending order
//                    return res != 0 ? res : 1; // to return in ascending order
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
}
