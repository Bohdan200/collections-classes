package hashmap;

import java.util.NoSuchElementException;
import java.util.Collection;
import java.util.Set;
import java.util.HashSet;

public class MyHashMap<K, V> {
    private Node<K, V> head;

    public void put(K key, V value) {
        Node<K, V> newNode = new Node<>();
        if (key == null) {
            key = (K) "null";
        }
        newNode.setKey(key);
        newNode.setValue(value);

        if (head == null) {
            head = newNode;
        } else {
            Node<K, V> lastNode = head;

            while (lastNode.getNext() != null) {
                if(lastNode.getKey().equals(key)) {
                    lastNode.setValue(value);
                    break;
                }
                lastNode = lastNode.getNext();
            }

            if(lastNode.getNext() == null && !lastNode.getKey().equals(key)) {
                lastNode.setNext(newNode);
            }
            if(lastNode.getNext() == null && lastNode.getKey().equals(key)) {
                lastNode.setValue(value);
            }
        }
    }

    public V get(K key) {
        if (head == null) {
            throw new IndexOutOfBoundsException("HashMap is empty");
        }

        V resultValue = null;
        Node<K, V> currentNode = head;
        int length = this.size();

        for (int i = 0; i < length; i++) {
            if(currentNode.getKey().equals(key)) {
                resultValue = currentNode.getValue();
                break;
            }

            currentNode = currentNode.getNext();
        }

        return resultValue;
    }

    public V remove(K key) {
        if (head == null) {
            throw new NoSuchElementException();
        }

        V removeValue = null;
        int removePosition = -1;
        int length = this.size();

        Node<K, V> currentNode = head;
        Node<K, V> nextNode = null;

        for (int i = 0; i < length; i++) {
            if (currentNode.getKey().equals(key)) {
                removeValue = currentNode.getValue();
                nextNode = currentNode.getNext();
                removePosition = i;
                break;
            }
            currentNode = currentNode.getNext();
        }

        if (removePosition == -1) {
            return null;
        }

        if (removePosition == 0) {
            removeValue = head.getValue();
            head = head.getNext();
        } else {
            currentNode = head;
            for (int j = 0; j < removePosition - 1; j++) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(nextNode);
        }

        return removeValue;
    }

    public void clear() {
        if (head != null) {
            Node<K, V> currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
                head = null;
            }
        }
    }

    public int size() {
        if (head == null) {
            return 0;
        }

        int count = 1;
        Node<K, V> lastNode = head;
        while (lastNode.getNext() != null) {
            lastNode = lastNode.getNext();
            count++;
        }

        return count;
    }

    public boolean containsKey(K key) {
        boolean result = false;
        int length = this.size();

        if (key == null) {
            key = (K) "null";
        }

        if (head != null) {
            Node<K, V> currentNode = head;

            for (int i = 0; i < length; i++) {
                if (currentNode.getKey().equals(key)) {
                    result = true;
                    break;
                }
                currentNode = currentNode.getNext();
            }
        }

        return result;
    }

    public boolean containsValue(V value) {
        boolean result = false;
        int length = this.size();

        if (head != null) {
            Node<K, V> currentNode = head;

            for (int i = 0; i < length; i++) {
                if(currentNode.getValue() == null) {
                    if(value == null) result = true;
                    continue;
                }

                if (currentNode.getValue().equals(value)) {
                    result = true;
                    break;
                }
                currentNode = currentNode.getNext();
            }
        }

        return result;
    }

    public Set<K> keySet() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        Set<K> keysSet = new HashSet<>();
        int length = this.size();

        Node<K, V> currentNode = head;
        for (int i = 0; i < length; i++) {
            keysSet.add(currentNode.getKey());
            currentNode = currentNode.getNext();
        }

        return keysSet;
    }

   public Collection<V> values() {
       if (head == null) {
           throw new NoSuchElementException();
       }

       Collection<V> valuesSet = new HashSet<>();
       int length = this.size();

       Node<K, V> currentNode = head;
       for (int i = 0; i < length; i++) {
           valuesSet.add(currentNode.getValue());
           currentNode = currentNode.getNext();
       }

       return valuesSet;
   }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }
        int length = this.size();

        StringBuilder result = new StringBuilder();
        Node<K, V> currentNode = head;
        for (int i = 0; i < length; i++) {
            result.append("{key: ").append(currentNode.getKey()).append("; value: ").append(currentNode.getValue()).append(";} ");
            currentNode = currentNode.getNext();
        }
        return "[ " + result + "]";
    }
}
