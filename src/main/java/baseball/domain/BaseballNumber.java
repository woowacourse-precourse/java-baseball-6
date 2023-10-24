package baseball.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class BaseballNumber {
    private final int[] numbers;

    BaseballNumber(int[] numbers) {
        this.numbers = Arrays.copyOf(numbers, numbers.length);
        checkNumbers();
    }

    public static BaseballNumber ofString(String inputString) {
        int[] numbers = Arrays.stream(inputString
                        .split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        return new BaseballNumber(numbers);
    }

    public BaseballHint getHintFrom(BaseballNumber other) {
        return new BaseballHint(getStrikes(other), getBalls(other));
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, 3);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof BaseballNumber)) {
            return false;
        }
        BaseballNumber otherNumber = (BaseballNumber) other;

        return Arrays.equals(numbers, otherNumber.getNumbers());
    }

    private void checkNumbers() {
        assert (numbers.length == 3);
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            assert (0 < number && number < 10);
            set.add(number);
        }
        if (set.size() != 3) {
            throw new IllegalArgumentException("서로 다른 3자리 수가 아닙니다. :" + Arrays.toString(numbers));
        }
    }

    private int getBalls(BaseballNumber other) {
        int[] otherNumbers = other.getNumbers();

        return (int) IntStream.range(0, 3)
                .filter(i -> numbers[i] != otherNumbers[i])
                .filter(i -> Arrays.stream(otherNumbers)
                        .anyMatch(n -> n == numbers[i]))
                .count();
    }

    private int getStrikes(BaseballNumber other) {
        int[] otherNumbers = other.getNumbers();
        return (int) IntStream.range(0, 3)
                .filter(i -> numbers[i] == otherNumbers[i])
                .count();
    }
}
