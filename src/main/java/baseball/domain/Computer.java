package baseball.domain;

import java.util.List;

public class Computer {

    private final List<Integer> numbers;

    public Computer(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean has(int number) {
        return numbers.contains(number);
    }

    public boolean isSameIndex(int number, int index) {
        return numbers.indexOf(number) == index;
    }
}