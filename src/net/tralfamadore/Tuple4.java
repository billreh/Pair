package net.tralfamadore;

/**
 * Class: Tuple4
 * Created by billreh on 12/23/16.
 */
public class Tuple4<T,U,V,W> {
    private T value1;
    private U value2;
    private V value3;
    private W value4;

    public Tuple4() {
    }

    public Tuple4(T value1, U value2, V value3, W value4) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.value4 = value4;
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

    public V getValue3() {
        return value3;
    }

    public void setValue3(V value3) {
        this.value3 = value3;
    }

    public W getValue4() {
        return value4;
    }

    public void setValue4(W value4) {
        this.value4 = value4;
    }

    public Object produceElement(int i) {
        switch (i) {
            case 0:
                return value1;
            case 1:
                return value2;
            case 2:
                return value3;
            case 3:
                return value4;
            default:
                return new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tuple4<?, ?, ?, ?> tuple4 = (Tuple4<?, ?, ?, ?>) o;

        if (value1 != null ? !value1.equals(tuple4.value1) : tuple4.value1 != null) return false;
        if (value2 != null ? !value2.equals(tuple4.value2) : tuple4.value2 != null) return false;
        if (value3 != null ? !value3.equals(tuple4.value3) : tuple4.value3 != null) return false;
        return value4 != null ? value4.equals(tuple4.value4) : tuple4.value4 == null;
    }

    @Override
    public int hashCode() {
        int result = value1 != null ? value1.hashCode() : 0;
        result = 31 * result + (value2 != null ? value2.hashCode() : 0);
        result = 31 * result + (value3 != null ? value3.hashCode() : 0);
        result = 31 * result + (value4 != null ? value4.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tuple4{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                ", value3=" + value3 +
                ", value4=" + value4 +
                '}';
    }
}
