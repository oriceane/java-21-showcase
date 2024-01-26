package main;

import java.util.List;

public class UnnamedVariable {

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
        final var aragorn = new Person("Aragorn", "", 50, new Human());
        final var legolas = new Person("Legolas", "", 50, new Elf());
        final var gimli = new Person("Gimli", "", 50, new Dwarf());

        final var people = List.of(frodo, aragorn, legolas, gimli);

        people.forEach(person -> {
            if (person instanceof Person(String firstName, _, _, _)) {
                System.out.println(STR."Hi \{firstName}!");
            }

            switch (person) {
                case Person(String firstName, _, _, Hobbit _) -> System.out.println(STR."\{firstName} is a hobbit.");
                case Person(String firstName, _, _, Elf _) -> System.out.println(STR."\{firstName} is an elf.");
                case Person(String firstName, _, _, Human _) -> System.out.println(STR."\{firstName} is a human.");
                default -> System.out.println("Probably a dwarf then...");
            }

            try {
                getToMordor(person);
            } catch (IllegalArgumentException _) {
                System.out.println(STR."\{person.fName()} does not make it to Mordor...");
            }
        });
    }

    private void getToMordor(Person person) {
        if (!person.fName.equals("Frodo")) {
            throw new IllegalArgumentException();
        }
    }
}
