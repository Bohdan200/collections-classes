package stack;

import java.util.NoSuchElementException;
import java.util.StringJoiner;
import java.util.Arrays;

public class MyStack <K> {
    private static final int INIT_SIZE = 10;
    private Object[] data;
    private int finalIndex;

    public MyStack() {
        data = new Object[INIT_SIZE];
    }

    public K push(K value) {
        increaseSize();

        data[finalIndex] = value;
        finalIndex++;

        return (K) data[finalIndex - 1];
    }

    private void increaseSize() {
        if (finalIndex == data.length) {
            int newSize = data.length * 2;
            Object[] newData = new Object[newSize];

            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }

    public  K remove(int index) {
        if (index > (finalIndex - 1) || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + finalIndex);
        }

        K removeValue = (K) data[index];

        K accValue;
        for (int i = index; i < finalIndex - 1; i++) {
            accValue = (K) data[i + 1];
            data[i] = accValue;
        }

        finalIndex --;
        return removeValue;
    }

    public void clear() {
        data = new Object[INIT_SIZE];
        finalIndex = 0;
    }

    public int size() {
        return finalIndex;
    }

    public int capasity() {
        return INIT_SIZE;
    }

    public boolean empty() {
        return finalIndex == 0;
    }

    public int search(K value) {
        int index = -1;
        for (int i = 0; i < finalIndex; i++) {
            if(data[i].equals(value)) {
                index = finalIndex - i;
                break;
            }
        }

        return index;
    }

    public K peek() {
        if (finalIndex == 0) {
            throw new NoSuchElementException("Stack is empty");
        }

        return (K) data[finalIndex - 1];
    }

    public K pop() {
        if (finalIndex == 0) {
            throw new NoSuchElementException("Stack is empty");
        }

        K removeElement = (K) data[finalIndex - 1];
        data[finalIndex - 1] = null;
        finalIndex--;

        return removeElement;
    }

    public boolean contains(K value) {
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

        K[] newStack = (K[]) new Object[last - first];
        System.arraycopy(data, first, newStack, 0, last);
        return Arrays.toString(newStack);
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
