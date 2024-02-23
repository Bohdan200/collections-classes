package stack;

import java.util.Stack;

public class MyStackTests {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        System.out.println("stack.empty() = " + stack.empty());
        System.out.println("stack.capasity() = " + stack.capasity());

        stack.push("Rob");
        stack.push("Bran");
        stack.push("John");
        System.out.println("stack.push(\"Rickon\") = " + stack.push("Rickon"));

        System.out.println("stack.size() = " + stack.size());
        System.out.println("stack.search(\"John\") = " + stack.search("John"));
        System.out.println("stack.contains(\"Bran\") = " + stack.contains("Bran"));
        System.out.println("stack.sublist(0, 3) = " + stack.sublist(0, 3));

        System.out.println("stack.remove(0) = " + stack.remove(0));
        System.out.println("stack = " + stack);

        System.out.println("stack.peek() = " + stack.peek());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("Finally stack = " + stack);

        stack.clear();
        System.out.println("stack.empty() = " + stack.empty());
    }
}
