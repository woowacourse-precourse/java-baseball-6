package baseball.domain.numbers;

import java.util.HashSet;
import java.util.List;

public final class BaseBallNumber {
    public static final int NUMBER_LENGTH = 3;

    private final List<Integer> number;

    public BaseBallNumber(List<Integer> number) {
        validateNumberSize(number);
        validateDuplicate(number);
        this.number = number;
    }

    List<Integer> getNumber() {
        return number;
    }

    private void validateDuplicate(List<Integer> numbers) {
        int distinctSize = new HashSet<>(numbers).size();

        if (numbers.size() != distinctSize) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}