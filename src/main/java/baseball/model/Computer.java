package baseball.model;

import java.util.List;

public class Computer {
    private final List<Integer> numbers;

    public Computer(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean isSameNumberAndDigit(int number, int digit) {
        if (number == numbers.get(digit)) {
            return true;
        }
        return false;
    }

    public boolean isExistNumberOf(int number) {
        if (numbers.contains(number)) {
            return true;
        }
        return false;
    }
}
