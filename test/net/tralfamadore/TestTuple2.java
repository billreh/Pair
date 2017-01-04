package net.tralfamadore;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

/**
 * Class: TestTuple2
 * Created by billreh on 12/23/16.
 */
public class TestTuple2 {
    @Test
    public void testTuple2() throws Exception {
        Tuple2<String,Integer> tuple1 = new Tuple2<>("Hello", 42);
        Tuple2<String,Integer> tuple2 = new Tuple2<>();
        tuple2.setValue1("Hello");
        tuple2.setValue2(42);
        assertEquals(tuple1, tuple2);
        Tuple2<Integer,String> tuple3 = tuple1.swap();
        assertEquals(tuple1.getValue1(), tuple3.getValue2());
        assertEquals(tuple1.getValue2(), tuple3.getValue1());
        assertEquals("Hello", tuple1.produceElement(0));
        assertEquals(42, tuple1.produceElement(1));
        Set<Tuple2<String,Integer>> tuples = new TreeSet<>( (t1, t2) -> {
            int res = t1.getValue2().compareTo(t2.getValue2());
            return res != 0 ? res : 1;
        });
        tuples.add(new Tuple2<>("A", 3));
        tuples.add(new Tuple2<>("B", 2));
        tuples.add(new Tuple2<>("C", 1));
        tuples.forEach(System.out::println);
    }
}
