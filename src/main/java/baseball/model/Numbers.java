package baseball.model;

import baseball.Validator;

import java.util.Arrays;
import java.util.List;

public class Numbers {
    private final static Validator validator = new Validator();

    private List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        validator.checkValidNumbers(numbers);
        this.numbers = numbers;
    }

    public Numbers(String stringNumbers) {
        validator.checkValidString(stringNumbers);
        List<Integer> numbers = Arrays.stream(stringNumbers.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
        validator.checkValidNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "numbers=" + numbers +
                '}';
    }
}