package switchhh;

import java.util.List;

public class SwitchExpression {

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
        // Pattern matching
        final var frodo = new Person("Frodo", "Baggins", 50, new Hobbit());
        final var aragorn = new Person("Aragorn", "Unknown", 87, new Human());
        final var legolas = new Person("Legolas", "Greenleaf", 2931, new Elf());
        final var gimli = new Person("Gimli", "Unknown", 139, new Dwarf());

        final var people = List.of(frodo, aragorn, legolas, gimli);

        people.forEach(person -> {
            switch (person) {
                case Person(String firstName, String lastName, int age, Hobbit h) -> System.out.println(STR."\{firstName} is a hobbit.");
                case Person(String firstName, String lastName, int age, Elf e) -> System.out.println(STR."\{firstName} is an elf.");
                case Person(String firstName, String lastName, int age, Human h) -> System.out.println(STR."\{firstName} is a human.");
                default -> System.out.println("Probably a dwarf then...");
            }
        });

        people.forEach(person -> {
            switch (person) {
                case Person(var firstName, var lastName, var age, var r) when r instanceof Hobbit -> System.out.println(STR."\{firstName} is a hobbit.");
                case Person(var firstName, var lastName, var age, var r) when r instanceof Elf -> System.out.println(STR."\{firstName} is an elf.");
                case Person(var firstName, var lastName, var age, var r) when r instanceof Human -> System.out.println(STR."\{firstName} is a human.");
                default -> System.out.println("Probably a dwarf then...");
            }
        });
    }
}
