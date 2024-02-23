package linkedlist;

import java.util.NoSuchElementException;

public class MyLinkedList<T> {
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

            newNode.setPrev(lastNode);
            lastNode.setNext(newNode);
        }
    }

    public void add(Node<T> node) {
        if (head == null) {
            head = node;
        } else {
            Node<T> lastNode = head;
            while (lastNode.getNext() != null) {
                lastNode = lastNode.getNext();
            }

            node.setPrev(lastNode);
            lastNode.setNext(node);
        }
    }

    public T get(int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }

        Node<T> search = head;
        for (int i = 0; i < index; i++) {
            search = search.getNext();

            if (search == null) {
                throw new IndexOutOfBoundsException("Invalid index: " + index + ", Size: " + size());
            }
        }

        return search.getValue();
    }

    public T getFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        return head.getValue();
    }

    public T getLast() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }

        Node<T> lastNode = head;
        while (lastNode.getNext() != null) {
            lastNode = lastNode.getNext();
        }

        return lastNode.getValue();
    }

    public T[] toArray() {
        if (head == null || head.getValue() == null) {
            return (T[]) new Object[0];
        }

        int length = this.size();
        T[] array = (T[]) new Object[length];
        Node<T> currentNode = head;
        int j = 0;

        for (int i = 0; i < length; i++) {
            array[j] = currentNode.getValue();
            j++;
            currentNode = currentNode.getNext();
        }

        return array;
    }

    public T set(int index, T value) {
        if (head == null) {
            throw new NoSuchElementException();
        }

        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        T changeNodeName = currentNode.getValue();
        currentNode.setValue(value);

        return changeNodeName;
    }

    public T set(int index, Node<T> newNode) {
        if (head == null) {
            throw new NoSuchElementException();
        }

        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        T changeNodeName = currentNode.getValue();
        currentNode.setValue(newNode.getValue());

        return changeNodeName;
    }

    public T remove(int index) {
        if (head == null) {
            throw new NoSuchElementException();
        }

        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        T removeName = currentNode.getValue();
        Node<T> prevNode = currentNode.getPrev();
        Node<T> nextNode = currentNode.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);

        return removeName;
    }

    public T remove(Node<T> node) {
        if (head == null) {
            throw new NoSuchElementException();
        }

        int length = this.size();
        T removeName = null;
        Node<T> currentNode = head;

        for (int i = 0; i < length; i++) {
            if (currentNode.getValue().equals(node.getValue())) {
                removeName = currentNode.getValue();
                Node<T> prevNode = currentNode.getPrev();
                Node<T> nextNode = currentNode.getNext();
                prevNode.setNext(nextNode);
                nextNode.setPrev(prevNode);
                break;
            }

            currentNode = currentNode.getNext();
        }

        return removeName;
    }

    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        T first = head.getValue();
        head = head.getNext();
        head.setPrev(null);

        return first;
    }

    public T removeLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        T last = null;
        Node<T> currentNode = head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        if (currentNode.getNext() == null) {
            last = currentNode.getValue();
            Node<T> prevNode = currentNode.getPrev();
            prevNode.setNext(null);
        }

        return last;
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

    public int indexOf(Node<T> searchNode) {
        if (head == null) {
            throw new NoSuchElementException();
        }

        int index = -1;
        int count = 0;
        int length = this.size();
        Node<T> currentNode = head;

        for (int i = 0; i < length; i++) {
            if (currentNode.getValue().equals(searchNode.getValue())) {
                index = count;
                break;
            }
            count++;
            currentNode = currentNode.getNext();
        }

        return index;
    }

    public int size() {
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

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }
        int length = this.size();

        StringBuilder result = new StringBuilder();
        Node<T> currentNode = head;
        for (int i = 0; i < length; i++) {
            result.append(currentNode.getValue()).append("; ");
            currentNode = currentNode.getNext();
        }
        return "[ " + result + "]";
    }
}
