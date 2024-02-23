package arraylist;

public class MyArrayListTests {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        System.out.println("list.isEmpty() = " + list.isEmpty());

        list.add("Damon");
        list.add("Steven");
        System.out.println("list.add(\"Elena\") = " + list.add("Elena"));
        System.out.println("list.add(\"Katherine\") = " + list.add("Katherine"));
        list.add("Jeremy");

        System.out.println("list.size() = " + list.size());
        list.trimToSize();

        System.out.println("list.indexOf(\"Damon\") = " + list.indexOf("Damon"));
        System.out.println("list.get(1) = " + list.get(1));

        list.add(4, "Caroline");
        System.out.println("list.contains(\"Steven\") = " + list.contains("Steven"));

        list.trimToSize();
        System.out.println("list.sublist(0, 2) = " + list.sublist(0, 2));
        System.out.println("list.clone() = " + list.clone());

        list.remove(5);
        list.remove(3);
        System.out.println("list after remove = " + list);

        list.clear();
        System.out.println("list after clear = " + list);
    }
}
