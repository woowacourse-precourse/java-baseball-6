package baseball.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Numbers {
    private final int numberOfDigitsInAnswer;
    private final List<Integer> numbers;

    public Numbers(int numberOfDigitsInAnswer) {
        this.numberOfDigitsInAnswer = numberOfDigitsInAnswer;
        this.numbers = new LinkedList<>();
    }

    public Numbers(int numberOfDigitsInAnswer, List<Integer> numbers) {
        this.numberOfDigitsInAnswer = numberOfDigitsInAnswer;
        this.numbers = numbers;
    }

    public boolean isComplete() {
        return numbers.size() == numberOfDigitsInAnswer;
    }

    public void appendNumber(int number) {
        if (numbers.size() < numberOfDigitsInAnswer) {
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
    }

    public int len() {
        return numbers.size();
    }

    public int getByIndex(int index) {
        return numbers.get(index);
    }

    public int getIndexByNumber(int number) {
        return numbers.indexOf(number);
    }


    @Override
    public String toString() {
        return "Numbers{" +
                "numbers=" + numbers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Numbers numbers1 = (Numbers) o;

        if (numberOfDigitsInAnswer != numbers1.numberOfDigitsInAnswer) {
            return false;
        }
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        int result = numberOfDigitsInAnswer;
        result = 31 * result + (numbers != null ? numbers.hashCode() : 0);
        return result;
    }
}
