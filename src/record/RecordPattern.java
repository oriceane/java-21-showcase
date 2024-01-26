package record;

import java.util.List;

public class RecordPattern {

    abstract class Race {
    }

    class Human extends Race {
    }

    class Elf extends Race {
    }

    class Hobbit extends Race {
    }

    class Dwarf extends Race {
    }

    record Person(String fName, String lName, int age, Race race) {
    }

    void main() {
        final var frodo = new Person("Frodo", "Baggins", 50, new Hobbit());
        final var aragorn = new Person("Aragorn", "Unknown", 87, new Human());
        final var legolas = new Person("Legolas", "Greenleaf", 2931, new Elf());
        final var gimli = new Person("Gimli", "Unknown", 139, new Dwarf());

        final var people = List.of(frodo, aragorn, legolas, gimli);

        people.forEach(person -> {
            // As of Java 16
            if (person instanceof Person p) {
                var race = p.race();

                if (race instanceof Hobbit) {
                    System.out.println(STR."(Java 16) Hobbit -> First name: \{p.fName()}, Last name: \{p.lName()}, Age: \{p.age()}");
                }
            }

            // As of java 21 - take 1
            if (person instanceof Person(String fName, String lName, int age, Hobbit race)) {
                System.out.println(STR."(Java 21) Hobbit -> First name: \{fName}, Last name: \{lName}, Age: \{age}");
            } else if (person instanceof Person(String fName, String lName, int age, Elf race)) {
                System.out.println(STR."(Java 21) Elf -> First name: \{fName}, Last name: \{lName}, Age: \{age}");
            } else if (person instanceof Person(String fName, String lName, int age, Human race)) {
                System.out.println(STR."(Java 21) Human -> First name: \{fName}, Last name: \{lName}, Age: \{age}");
            } else {
                System.out.println("(Java 21) Probably a dwarf then...");
            }

            // Take 2 -> record patterns are flexible. A pattern variable’s type only needs to be compatible with the record’s components.
            if (person instanceof Person(var f, var l, var a, Hobbit r)) {
                var s = STR."Person -> First name: \{f}, Last name: \{l}, Age: \{a}";
            }
        });
    }
}
