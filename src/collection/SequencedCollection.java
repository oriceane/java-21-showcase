package collection;

import java.util.ArrayList;
import java.util.List;

public class SequencedCollection {

    /*
    interface SequencedCollection<E> extends Collection<E> {
        // new method
        SequencedCollection<E> reversed();
        // methods promoted from Deque
        void addFirst(E);
        void addLast(E);
        E getFirst();
        E getLast();
        E removeFirst();
        E removeLast();
    }
     */
    void main() {
        final var list = new ArrayList<>();
        list.add("First");
        list.add("Second");
        list.add("Last");

        // Getting the first element
        System.out.println(STR."First element: \{list.get(0)}");
        System.out.println(STR."First element: \{list.getFirst()}");

        // Getting the last element
        System.out.println(STR."Last element: \{list.get(list.size() - 1)}");
        System.out.println(STR."Last element: \{list.getLast()}");

        // Reversing a list
        System.out.println(STR."Original: \{list}");
        System.out.println(STR."Reversed: \{list.reversed()}");

        // For example, obtaining a reverse-ordered stream from a list was previously quite difficult; now it is simply
        list.reversed().forEach(element -> System.out.println(STR."Element: \{element}"));

        // Watch out for unsupported operation exceptions
        final var list2 = List.of(1, 2, 3);
//        list2.addLast(4);  //Exception in thread "main" java.lang.UnsupportedOperationException

        // NoSuchElementException on empty collections
        final var list3 = List.of();
//        list3.getFirst();  //Exception in thread "main" java.lang.NoSuchElementException
    }

}
