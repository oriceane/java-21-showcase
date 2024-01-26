package string;

import static java.util.FormatProcessor.FMT;

import java.text.MessageFormat;

public class StringTemplate {

    void main() {
        final var x = 1;
        final var y = 2;

        // Current options

        // hard to read
        final var concatenation = x + " plus " + y + " equals " + (x + y);
        System.out.println("Concatenation:\t\t\t" + concatenation);

        // verbose
        final var stringBuilder = new StringBuilder()
                .append(x)
                .append(" plus ")
                .append(y)
                .append(" equals ")
                .append(x + y)
                .toString();
        System.out.println("String builder:\t\t\t" + stringBuilder);

        // easy to end up with mistakes / type mismatches
        final var format = String.format("%1$d plus %2$d equals %3$d", x, y, x + y);
        System.out.println("Format:\t\t\t\t\t" + format);
        final var formatted = "%1$d plus %2$d equals %3$d".formatted(x, y, x + y);
        System.out.println("Formatted:\t\t\t\t" + formatted);

        // too much ceremony, although similar to slf4j syntax
        final var messageFormatted = MessageFormat.format("{0} plus {1} equals {2}", x, y, x + y);
        System.out.println("Message format:\t\t\t" + messageFormatted);

        // String interpolation (e.g. in python)
        // f"{x} plus {y} equals {x + y}"

        // New! String templates
        final var template = STR."\{x} plus \{y} equals \{x + y}";
        System.out.println("Template:\t\t\t\t" + template);

        // Format processor
        System.out.println(FMT."""
        X        Y
        %d\{x}        %d\{y}
        """);
    }
}