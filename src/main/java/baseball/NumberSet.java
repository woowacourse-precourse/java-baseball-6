package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        return (
                this.numbers.get(0) != this.numbers.get(1)
                        && this.numbers.get(0) != this.numbers.get(2)
                        && this.numbers.get(1) != this.numbers.get(2)
        );
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

    public static int getStrikes(NumberSet a, NumberSet b) {
        int strikes = 0;
        strikes += a.getNumbers().get(0) == b.getNumbers().get(0) ? 1 : 0;
        strikes += a.getNumbers().get(1) == b.getNumbers().get(1) ? 1 : 0;
        strikes += a.getNumbers().get(2) == b.getNumbers().get(2) ? 1 : 0;
        return strikes;
    }

    public static int getBalls(NumberSet a, NumberSet b) {
        int balls = 0;
        balls += a.getNumbers().get(0) == b.getNumbers().get(1) || a.getNumbers().get(0) == b.getNumbers().get(2) ? 1 : 0;
        balls += a.getNumbers().get(1) == b.getNumbers().get(0) || a.getNumbers().get(1) == b.getNumbers().get(2) ? 1 : 0;
        balls += a.getNumbers().get(2) == b.getNumbers().get(0) || a.getNumbers().get(2) == b.getNumbers().get(1) ? 1 : 0;
        return balls;
    }

    public static GuessResult compare(NumberSet a, NumberSet b) {
        return new GuessResult(
                getStrikes(a, b),
                getBalls(a, b)
        );
    }
}
