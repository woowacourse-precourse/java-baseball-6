package baseball.model;

import java.util.List;

public class Computer {

    private final List<Integer> numbers;

    public Computer(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    public boolean isSameIndex(int number, int index) {
        return numbers.indexOf(number) == index;
    }
}
