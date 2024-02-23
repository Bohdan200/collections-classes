package queue;

public class MyQueueTests {
    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>();

        queue.add("Ned");
        queue.add("Robert");
        queue.add("Jaime");
        queue.add("Cerise");

        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue.contains(\"Cerise\") = " + queue.contains("Cerise"));

        queue.poll();
        queue.remove();
        System.out.println("queue.size() = " + queue.size());
        System.out.println("queue = " + queue);

        queue.clear();
        System.out.println("queue.isEmpty() = " + queue.isEmpty());
    }

}

