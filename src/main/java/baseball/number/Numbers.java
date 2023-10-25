package baseball.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Numbers {
    public static final int NUMBERS_LENGTH = 3;
    public static final String INVALID_NUMBER_LENGTH_MESSAGE = "숫자는 3자리여야 합니다.";
    public static final String INVALID_DUPLICATE_NUMBER_MESSAGE = "중복된 숫자는 입력할 수 없습니다.";

    private List<Number> numbers;

    public Numbers() {
        this.numbers = new ArrayList<>();
    }

    public Numbers(String numberText) {
        validate(numberText);
        this.numbers = Arrays.stream(numberText.split(""))
                .map(Number::new)
                .toList();
    }

    private void validate(String numberText) {
        validateNumberLength(numberText);
        validateDuplicateNumber(numberText);
    }

    private static void validateNumberLength(String numberText) {
        if (numberText.length() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException(INVALID_NUMBER_LENGTH_MESSAGE);
        }
    }

    private void validateDuplicateNumber(String numberText) {
        long count = Arrays.stream(numberText.split(""))
                .distinct()
                .count();

        if (count != NUMBERS_LENGTH) {
            throw new IllegalArgumentException(INVALID_DUPLICATE_NUMBER_MESSAGE);
        }
    }

    public void add(Number number) {
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }

    public boolean isMoreSelect() {
        return numbers.size() != NUMBERS_LENGTH;
    }

    public List<Number> getNumbers() {
        return numbers;
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
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
