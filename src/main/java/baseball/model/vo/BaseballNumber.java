package baseball.model.vo;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class BaseballNumber {

    private final List<Integer> number;

    // constructor
    private BaseballNumber(List<Integer> input) {
        validateNotIncludeZero(input);
        validateNot3Digit(input);
        validateDuplicate(input);
        this.number = input;
    }

    // immutable object
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseballNumber that = (BaseballNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    // exception handling
    private void validateNotIncludeZero(List<Integer> input) {
        if (isNotIncludeZero(input)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNot3Digit(List<Integer> input) {
        if (is3Digit(input)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> input) {
        if (isDuplicateEachNumber(input)){
            throw new IllegalArgumentException();
        }
    }

    // validation
    private boolean isNotIncludeZero(List<Integer> input) {
        return input.stream()
                .allMatch(n -> n != 0);
    }
    private boolean is3Digit(List<Integer> input) {
        return input.size() != 3;
    }

    private boolean isDuplicateEachNumber(List<Integer> input) {
        return new HashSet<>(input)
                .size() != 3;
    }

    // getter
    public List<Integer> getNumber() {
        return List.copyOf(number);
    }
}
