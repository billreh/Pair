package net.tralfamadore;

import java.util.*;

/**
 * Class: Pair
 * Created by billreh on 12/20/16.
 *
 * A class to keep pairs of values.  Note that when comparing pairs, a pair with <code>value1 == x</code>
 * and <code>value2 == y</code> is the same as <code>value1 == y</code> and <code>value2 == x</code>.
 *
 * @param <T> The pair type.
 */
public class Pair<T> {
    protected T value1;
    protected T value2;

    /**
     * Create a list of unique pairs from a given collection.
     *
     * @param list The collection to create pairs from.
     *
     * @return A list of unique pairs.
     */
    public static <T>List<Pair<T>> from(Collection<T> list) {
        List<Pair<T>> pairs = new ArrayList<>();

        for(T e : list) {
            Pair<T> p = new Pair<>();
            p.setValue1(e);
            pairs.add(p);
        }

        List<Pair<T>> allPairs = new ArrayList<>();
        for(T e : list) {
            for(Pair<T> p : pairs) {
                Pair<T> p2 = new Pair<>(p.getValue1(), e);
                allPairs.add(p2);
            }
        }

        Set<Pair<T>> uniquePairs = new HashSet<>();

        for(Pair<T> p : allPairs) {
            if(p.getValue1().equals(p.getValue2()))
                continue;
            if(uniquePairs.contains(p))
                continue;
            uniquePairs.add(p);
        }

        List<Pair<T>> ret = new ArrayList<>();
        ret.addAll(uniquePairs);

        return ret;
    }

    public Pair() {
    }

    public Pair(T value1, T value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public T getValue1() {
        return value1;
    }

    public void setValue1(T value1) {
        this.value1 = value1;
    }

    public T getValue2() {
        return value2;
    }

    public void setValue2(T value2) {
        this.value2 = value2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair<?> pair = (Pair<?>) o;

        if (value1 != null && value2 != null)
            if (value1.equals(pair.getValue2()) && value2.equals(pair.getValue1()))
                return true;
        if (value1 == null && pair.getValue1() == null)
            return value2 == null && pair.getValue2() == null;

        return (value1 != null ? value1.equals(pair.value1) : pair.value1 == null) &&
                (value2 != null ? value2.equals(pair.value2) : pair.value2 == null);
    }

    @Override
    public int hashCode() {
        int result = value1 != null ? value1.hashCode() : 0;
        result = 31 * result + (value2 != null ? value2.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                '}';
    }
}
