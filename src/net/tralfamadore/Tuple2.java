package net.tralfamadore;

import java.util.Comparator;

/**
 * Class: Tuple2
 * Created by billreh on 12/23/16.
 */
public class Tuple2<T,U> {
    private Comparator<? super T> comparator = null;
    private T value1;
    private U value2;

    public Tuple2() {
    }

    public Tuple2(T value1, U value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public T getValue1() {
        return value1;
    }

    public void setValue1(T value1) {
        this.value1 = value1;
    }

    public U getValue2() {
        return value2;
    }

    public void setValue2(U value2) {
        this.value2 = value2;
    }

    public Tuple2<U,T> swap() {
        return new Tuple2<U, T>(value2, value1);
    }

    public Object produceElement(int i) {
        switch (i) {
            case 0:
                return value1;
            case 1:
                return value2;
            default:
                return new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tuple2<?, ?> tuple2 = (Tuple2<?, ?>) o;

        if (value1 != null ? !value1.equals(tuple2.value1) : tuple2.value1 != null) return false;
        return value2 != null ? value2.equals(tuple2.value2) : tuple2.value2 == null;
    }

    @Override
    public int hashCode() {
        int result = value1 != null ? value1.hashCode() : 0;
        result = 31 * result + (value2 != null ? value2.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tuple2{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                '}';
    }
}
