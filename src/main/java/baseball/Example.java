package baseball;

import org.assertj.core.util.TriFunction;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.function.*;

public class Example {

    public static void main(String[] args) {
        Executable exe = text -> Printer.printSomething(text);
        Executable exe2 = Printer::printSomething;
        exe.doSomething("do something");
        exe2.doSomething("do something");

        // consumer is a functional interface in java.util.function package
        // consumer has no return type and takes a single argument
        Consumer<String> consumer = Printer::printSomething;
        consumer.accept("print something");

        // forEach method in Stream interface
        List<String> companies = Arrays.asList("google", "apple", "google", "apple", "samsung");
        companies.stream().forEach(company -> System.out.println(company));
        companies.stream().forEach(System.out::println);

        // runnable is a functional interface in java.lang package
        // runnable has no return type and takes no argument
        Runnable runnable = Generator::random;
        runnable.run();

        // supplier is a functional interface in java.util.function package
        // supplier has a return type and takes no argument
        Supplier<String> supplier = Generator::random;
        String random = supplier.get();

        // function is a functional interface in java.util.function package
        // function has a return type and takes a single argument
        Function<String, String> function = Changer::change;
        String changed = function.apply("change me");
        Function<String, Integer> toInt = Changer::toInt;
        Integer changedToInt = toInt.apply("123");

        // comparator is a functional interface in java.util package
        // comparator has a return type and takes two arguments
        Comparator<Integer> comparator = Calculator::add;
        int compared = comparator.compare(1, 2);

        // binaryOperator is a functional interface in java.util.function package
        // binaryOperator has a return type and takes two arguments
        BinaryOperator<Integer> binaryOperator = Calculator::add;
        int three = binaryOperator.apply(1, 2);

        TriFunction<Integer, Integer, Integer, Integer> unaryOperator = Calculator::add;
        int six = unaryOperator.apply(1, 2, 3);
    }

    interface Executable {
        void doSomething(String text);
    }

    public static class Printer {
        static void printSomething(String text) {
            System.out.println(text);
        }
    }

    public static class Generator {
        static String random() {
            return UUID.randomUUID().toString();
        }
    }

    public static class Changer {
        static String change(String text) {
            return text.toUpperCase();
        }

        static Integer toInt(String text) {
            return Integer.parseInt(text);
        }
    }

    public static class Calculator {
        static int add(int... a) {
            return Arrays.stream(a).sum();
        }
    }
}
