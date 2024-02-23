package arraylist;

import java.util.Arrays;
import java.util.StringJoiner;

public class MyArrayList<T> {
    private static final int INIT_SIZE = 10;
    private Object[] data;
    private int finalIndex;

    public MyArrayList() {
        data = new Object[INIT_SIZE];
    }

    public boolean add(T value) {
        increaseSize();

        data[finalIndex] = value;
        finalIndex++;

        return true;
    }

    public void add(int index, T value) {
        if(index > finalIndex - 1 || index < 0) {
            throw new IndexOutOfBoundsException("index higher than maximum");
        }
        increaseSize();
        finalIndex++;

        T currValue;
        T accValue = (T) data[index];
        data[index] = value;
        for (int i = index + 1; i < finalIndex; i++) {
            currValue = (T) data[i];
            data[i] = accValue;
            accValue = currValue;
        }
    }

    private void increaseSize() {
        if (finalIndex == data.length) {
            int newSize = data.length * 2;
            Object[] newData = new Object[newSize];

            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }

    public void trimToSize() {
        if (finalIndex != data.length) {
            Object[] newData = new Object[finalIndex];
            System.arraycopy(data, 0, newData, 0, finalIndex);
            data = newData;
        }
    }

    public T get(int i) {
        return (T) data[i];
    }

    public int size() {
        return finalIndex;
    }

    public boolean isEmpty() {
        return finalIndex == 0;
    }

    public boolean contains(T value) {
        boolean result = false;

        for (int i = 0; i < finalIndex; i++) {
            if(data[i].equals(value)) {
                result = true;
                break;
            }
        }

        return result;
    }

    public String sublist(int first, int last) {
        if(first > last || first < 0) {
            throw new IllegalArgumentException("Incorrect argument values");
        }

        if (first == last) {
            return  Arrays.toString(new Object[0]);
        }

        T[] newArrayList = (T[]) new Object[last - first];
        System.arraycopy(data, first, newArrayList, 0, last);
        return Arrays.toString(newArrayList);
    }

    public String clone() {
        T[] newArrayList = (T[]) new Object[finalIndex];
        System.arraycopy(data, 0, newArrayList, 0, finalIndex);
        return Arrays.toString(newArrayList);
    }

    public  T remove(int index) {
        if (index > (finalIndex - 1) || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + finalIndex);
        }

        T removeValue = (T) data[index];

            T accValue;
            for (int i = index; i < finalIndex - 1; i++) {
                accValue = (T) data[i + 1];
                data[i] = accValue;
            }

        finalIndex --;
        return removeValue;
    }

    public void clear() {
        data = new Object[INIT_SIZE];
        finalIndex = 0;
    }

    public int indexOf(T value) {
        int result = -1;

        for (int i = 0; i < finalIndex; i++) {
            if(data[i].equals(value)) {
                result = i;
                break;
            }
        }

        return result;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for (int i = 0; i < finalIndex; i++) {
            result.add(data[i].toString());
        }

        return "[" + result + "]";
    }
}
