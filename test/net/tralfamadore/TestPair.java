package net.tralfamadore;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * Class: TestPair
 * Created by billreh on 12/20/16.
 */
public class TestPair {
    private static String[] logEntries = { "yahoo,ap42", "google,ap42", "tweeter,th176", "google,aa314", "google,aa314",
            "google,th176", "tweeter,aa314", "tweeter,ap42", "yahoo,aa314"};

    private static List<String> getLogEntries() {
        return Arrays.asList(logEntries);
    }

    @Test
    public void testReadFileAsPairs() throws IOException {
        List<String[]> words = Files.lines(new File("/Users/billreh/Downloads/jasypt-1.9.2/NOTICE.txt").toPath()).
                map(l -> l.split("\\s+")).collect(toList());
        List<Pair> pairs = new ArrayList<>();
        words.forEach(w -> pairs.addAll(Pair.from(Arrays.asList(w))));
        System.out.println(pairs);
    }

    @Test
    public void testHighestAffinity() throws Exception {
        List<AffinityPair> pairs = createAffinities(getLogEntries());

        AffinityPair highestAffinity = findHighestAffinity(pairs);

        System.out.println("The pair with the highest affinity is: " + highestAffinity);
    }

    private static AffinityPair findHighestAffinity(List<AffinityPair> affinityPairs) {
        AffinityPair target = new AffinityPair();

        for(AffinityPair p : affinityPairs) {
            if(p.getUsers().size() > target.getUsers().size())
                target = p;
        }

        return target;
    }

    /**
     * Create a list of AffinityPairs from a list of log entries.
     *
     * @param logEntries A comma separated list of Strings with each entry in the format of company,user
     *
     * @return A list of AffinityPairs
     */
    private static List<AffinityPair> createAffinities(List<String> logEntries) {
        Map<String,List<String>> entries = new HashMap<>();

        for(String e : logEntries) {
            String[] keyVal = e.split(",");
            if(!entries.containsKey(keyVal[0]))
                entries.put(keyVal[0], new ArrayList<>());
            entries.get(keyVal[0]).add(keyVal[1]);
        }

        List<AffinityPair> affinityPairs = new ArrayList<>();
        for(Pair<String> pair : Pair.from(entries.keySet()))
            affinityPairs.add(new AffinityPair(pair.getValue1(), pair.getValue2()));

        for(AffinityPair p : affinityPairs) {
            Set<String> s1 = new HashSet<>();
            s1.addAll(entries.get(p.getValue1()));
            Set<String> s2 = new HashSet<>();
            s2.addAll(entries.get(p.getValue2()));
            s1.retainAll(s2);
            p.setUsers(s1);
        }

        return affinityPairs;
    }
}

class AffinityPair extends Pair<String> {
    private Collection<String> users = new ArrayList<>();

    AffinityPair() {
    }

    AffinityPair(String value1, String value2) {
        super(value1, value2);
    }

    Collection<String> getUsers() {
        return users;
    }

    void setUsers(Collection<String> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "AffinityPair{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                ", users=" + users +
                "}";
    }
}
