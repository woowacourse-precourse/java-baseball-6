package baseball.domain;

import baseball.util.Util;

import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    private final List<Number> value;

    private Numbers(final List<Number> numbers) {
        this.value = numbers;
    }

    public static Numbers of(final List<Integer> numbers) {
        if (Util.validDuplicatedNumbers(numbers)) {
            return new Numbers(numbers.stream()
                    .map(number -> Number.from(number))
                    .collect(Collectors.toList()));
        }
        throw new IllegalArgumentException("잘못된 입력입니다.");
    }
}
