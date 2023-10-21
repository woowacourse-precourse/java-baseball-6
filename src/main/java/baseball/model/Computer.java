package baseball.model;

import baseball.NumberGenerator;

import java.util.List;

public class Computer {

    private final List<Integer> numbers;

    private Computer(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Computer createWithGenerator(final NumberGenerator generator) {
        return new Computer(generator.generate());
    }
}

