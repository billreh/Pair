package net.tralfamadore;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Class: TestTuple3
 * Created by billreh on 12/23/16.
 */
public class TestTuple3 {
    @Test
    public void testTuple3() throws Exception {
        Tuple3<String,Integer,List<String>> tuple3 = new Tuple3<>("People", 3, Arrays.asList("Bill", "Snuffy", "Sailor"));
        Tuple3<String,Integer,List<String>> tuple31 = new Tuple3<>("People", 3, Arrays.asList("Bill", "Snuffy", "Sailor"));
        assertEquals(tuple3, tuple31);
        assertEquals("People", tuple3.getValue1());
        assertEquals("People", tuple3.produceElement(0));
        try {
            tuple3.produceElement(3);
        } catch (Exception e) {
            assertEquals(e.getClass(), IndexOutOfBoundsException.class);
        }
    }
}
