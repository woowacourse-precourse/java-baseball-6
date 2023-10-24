package baseball;

import java.util.*;

public class NumberSet {
    private List<Integer> numbers;

    public NumberSet(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public NumberSet(Integer... digits) {
        this.numbers = Arrays.asList(digits);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean isUnique() {
        Set<Integer> set = new HashSet<>(this.numbers);
        return set.size() == this.numbers.size();
    }

    public static NumberSet parseFrom(int number) throws IllegalArgumentException {
        if (number < 100 || number > 999)
            throw new IllegalArgumentException();
        return new NumberSet(
                number / 100,
                (number / 10) % 10,
                number % 10
        );
    }

    public static NumberSet parseFrom(String string) throws IllegalArgumentException {
        if (string.length() != 3)
            throw new IllegalArgumentException();
        int number;
        try {
            number = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return NumberSet.parseFrom(number);
    }
}
