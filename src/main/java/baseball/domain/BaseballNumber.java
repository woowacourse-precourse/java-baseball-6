package baseball.domain;

import java.util.HashSet;
import java.util.List;

public class BaseballNumber {
    private List<Integer> numbers;

    public BaseballNumber(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean hit(int target, int index) {
        return numbers.get(index).equals(target);
    }

    public boolean contain(int target) {
        return numbers.contains(target);
    }

    private void validate(List<Integer> numbers) {
        validateDuplicate(numbers);
        validateNumbersSize(numbers);
        valdateIncludeZero(numbers);
    }

    private void valdateIncludeZero(List<Integer> numbers) {
        if (numbers.contains(0)) {
            throw new NotAllowZeroNunberException();
        }
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalNumberLengthException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        int origin = numbers.size();
        int target = new HashSet<>(numbers).size();
        if (origin != target) {
            throw new DuplicatNunberException();
        }
    }

    public static class IllegalNumberLengthException extends IllegalArgumentException {
    }

    public static class DuplicatNunberException extends IllegalArgumentException {
    }

    public static class NotAllowZeroNunberException extends IllegalArgumentException {
    }
}
