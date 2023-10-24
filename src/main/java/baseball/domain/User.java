package baseball.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public record User(List<Integer> numbers) {
    private static final Integer USER_NUMBER_MAX_SIZE = 3;

    public User {
        if (numbers.size() != USER_NUMBER_MAX_SIZE) {
            throw new IllegalArgumentException("숫자 입력은 3자리만 가능합니다.");
        }
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }

    }

    public User(final String input) {
        this(Arrays.stream(input.split(""))
                .map(User::convertStringToInteger)
                .peek(User::validateNumberInRange)
                .toList());
    }

    private static Integer convertStringToInteger(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception exception) {
            throw new IllegalArgumentException("문자열은 입력할 수 없습니다.");
        }
    }

    private static void validateNumberInRange(final Integer input) {
        if (input < 1) {
            throw new IllegalArgumentException("1보다 커야 합니다.");
        }
    }
}
