package baseball.model;

import baseball.utils.NumbersGenerator;

import java.util.List;

public class ComputerNumber {
    private final List<Integer> numbers;

    private ComputerNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static ComputerNumber create() {
        List<Integer> numbers = NumbersGenerator.generate();
        return new ComputerNumber(numbers);
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    public int findNumberByPosition(int position) {
        return numbers.get(position);
    }
}