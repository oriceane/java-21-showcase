package collection;

import java.util.LinkedHashMap;

public class SequencedMap {

    /*
    interface SequencedMap<K,V> extends Map<K,V> {
        // new methods
        SequencedMap<K,V> reversed();
        SequencedSet<K> sequencedKeySet();
        SequencedCollection<V> sequencedValues();
        SequencedSet<Entry<K,V>> sequencedEntrySet();
        V putFirst(K, V);
        V putLast(K, V);
        // methods promoted from NavigableMap
        Entry<K, V> firstEntry();
        Entry<K, V> lastEntry();
        Entry<K, V> pollFirstEntry();
        Entry<K, V> pollLastEntry();
    }
     */
    void main() {
        final var map = new LinkedHashMap<>();
        map.putFirst("First", 1);
        map.put("Second", 2);
        map.putLast("Last", 3);

        // Getting the first element
        System.out.println(STR."First entry: \{map.firstEntry()}");
        System.out.println(STR."Last entry: \{map.lastEntry()}");

        // Reversing a list
        System.out.println(STR."Original: \{map}");
        System.out.println(STR."Reversed: \{map.reversed()}");

        // Maps can be polled too
        map.pollFirstEntry();
        map.pollLastEntry();

        System.out.println(STR."Polled: \{map}");
    }

}
