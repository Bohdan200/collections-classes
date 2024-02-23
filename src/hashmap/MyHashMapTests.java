package hashmap;

public class MyHashMapTests {
    public static void main(String[] args) {
        MyHashMap<String, Integer> hashMap = new MyHashMap<>();
        hashMap.put("Maxim", null);
        hashMap.put("Denis", 30);
        hashMap.put("Maxim", 25);
        hashMap.put(null, 12);
        hashMap.put(null, 17);
        hashMap.put("Igor", null);
        hashMap.put("Denis", 37);

        System.out.println("hashMap = " + hashMap);

        System.out.println("hashMap.get(\"Maxim\") = " + hashMap.get("Maxim"));
        System.out.println("hashMap.get(\"Denis\") = " + hashMap.get("Denis"));

        System.out.println("hashMap.containsKey(null) = " + hashMap.containsKey(null));
        System.out.println("hashMap.containsKey(\"Igor\") = " + hashMap.containsKey("Igor"));
        System.out.println("hashMap.containsValue(17) = " + hashMap.containsValue(17));
        System.out.println("hashMap.containsValue(null) = " + hashMap.containsValue(null));

        for (String key : hashMap.keySet()) {
            System.out.println("key = " + key);
        }
        for (Integer value : hashMap.values()) {
            System.out.println("value = " + value);
        }

        System.out.println("hashMap.size = " + hashMap.size());
        System.out.println("hashMap.remove(\"Maxim\") = " + hashMap.remove("Maxim"));
        System.out.println("hashMap.remove(\"Igor\") = " + hashMap.remove("Igor"));
        System.out.println("hashMap = " + hashMap);

        hashMap.clear();
        System.out.println("hashMap after clear = " + hashMap);
    }
}
