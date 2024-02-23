package linkedlist;

import java.util.Arrays;

public class MyLinkedListTests {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.add("Alfa");
        list.add("Beta");
        list.add("Gamma");
        list.add("Delta");
        list.add("Epsilon");
        list.add("Sigma");

        Node<String> newElement = new Node<>("Psi");
        list.add(newElement);
        System.out.println("list.toString() = " + list);

        Node<String> changeElement = new Node<>("Theta");
        System.out.println("list.set(1, changeElement) = " + list.set(1, changeElement));
        System.out.println("list.set(6, \"Omega\") = " + list.set(6, "Omega"));

        System.out.println("list.toString() = " + list);
        System.out.println("list.getFirst() = " + list.getFirst());
        System.out.println("list.getLast() = " + list.getLast());
        System.out.println("list.get(0) = " + list.get(0));
        System.out.println("list.size() = " + list.size());
        System.out.println("list.toArray() = " + Arrays.toString(list.toArray()));
        // index - 3
        Node<String> searchElement = new Node<>("Delta");
        System.out.println("list.indexOf(searchElement) = " + list.indexOf(searchElement));

        // remove 4 - Epsilon
        System.out.println("list.remove(4) = " + list.remove(4));
        // remove - Gamma
        Node<String> removeElement = new Node<>("Gamma");
        System.out.println("list.remove(removeElement) = " + list.remove(removeElement));

        // remove Alfa
        System.out.println("list.removeFirst() = " + list.removeFirst());
        // remove Sigma
        System.out.println("list.removeLast() = " + list.removeLast());
        System.out.println("list.toString() = " + list);
        // clear list
        list.clear();
        System.out.println("list after clear = " + Arrays.toString(list.toArray()));
    }
}
