package baseball.domain;

import baseball.util.Util;

import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    private static final int NUMBERS_SIZE = 3;
    private final List<Number> value;

    private Numbers(final List<Number> numbers) {
        this.value = numbers;
    }

    public static Numbers of(final List<Integer> numbers) {
        if (Util.validDuplicatedNumbers(numbers) && Util.validNumbersCount(numbers, NUMBERS_SIZE)) {
            return new Numbers(numbers.stream()
                    .map(number -> Number.from(number))
                    .collect(Collectors.toList()));
        }
        throw new IllegalArgumentException("잘못된 입력입니다.");
    }
}
