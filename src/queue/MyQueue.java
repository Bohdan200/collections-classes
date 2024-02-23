package queue;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class MyQueue<T> {
    private Node<T> head;

    public void add(T item) {
        Node<T> newNode = new Node<>();
        newNode.setValue(item);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> lastNode = head;
            while (lastNode.getNext() != null) {
                lastNode = lastNode.getNext();
            }

            lastNode.setNext(newNode);
        }
    }

    public T peek() {
        if (head == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        return head.getValue();
    }

    public T poll() {
        if (head == null) {
            throw new NoSuchElementException("Queue is empty");
        }

        T result = head.getValue();
        head = head.getNext();

        return result;
    }

    public void remove() {
        if (head == null) {
            throw new NoSuchElementException("Queue is empty");
        }

        head = head.getNext();
    }

    public void clear() {
        if (head != null) {
            Node<T> currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
                head = null;
            }
        }
    }

    public boolean contains(T value) {
        boolean result = false;

        if (head != null) {
            Node<T> currentNode = head;
            int length = this.size();

            for (int i = 0; i < length; i++) {
                if (currentNode.getValue().equals(value)) {
                    result = true;
                    break;
                }

                currentNode = currentNode.getNext();
            }

        }

        return result;
    }

        public int size () {
            if (head == null) {
                return 0;
            }

            int count = 1;
            Node<T> lastNode = head;
            while (lastNode.getNext() != null) {
                lastNode = lastNode.getNext();
                count++;
            }

            return count;
        }

        public boolean isEmpty() {
            return head == null;
        }

        @Override
        public String toString () {
            Node<T> currentNode = head;
            StringJoiner result = new StringJoiner(", ");

            for (int i = 0; i < this.size(); i++) {
                result.add(currentNode.getValue().toString());
                currentNode = currentNode.getNext();
            }

            return "[" + result + "]";
        }

}
