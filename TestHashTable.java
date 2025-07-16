public class TestHashTable {

    public static void main(String[] args) {
        HashTable<String> ht = new HashTable<String>();

        ht.add("apple");
        ht.add("banana");
        ht.add("carrot");
        ht.add("apple");   // duplicate to test collision
        ht.add("banana");  // another duplicate
        ht.add("donut");

        System.out.println(ht.toString());
    }
}
