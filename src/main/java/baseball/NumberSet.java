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

    public static int getStrikes(NumberSet a, NumberSet b) {
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            Integer aDigit = a.getNumbers().get(i);
            Integer bDigit = b.getNumbers().get(i);
            if (aDigit.equals(bDigit))
                strikes++;
        }
        return strikes;
    }

    public static int getBalls(NumberSet a, NumberSet b) {
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) continue;
                Integer aDigit = a.getNumbers().get(i);
                Integer bDigit = b.getNumbers().get(j);
                if (aDigit.equals(bDigit))
                    balls++;
            }
        }
        return balls;
    }

    public static GuessResult compare(NumberSet a, NumberSet b) {
        return new GuessResult(
                getStrikes(a, b),
                getBalls(a, b)
        );
    }
}
