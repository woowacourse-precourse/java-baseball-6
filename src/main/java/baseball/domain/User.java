package baseball.domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class User {

    private static final int NUM_COUNT = 3;
    private static final String REGEX = String.format("^[1-9]{%d}$", NUM_COUNT);


    private final String input;

    public User(String number) {
        validate(number);
        this.input = number;
    }

    private void validate(String input) {
        validateFormat(input);
        validateDuplicate(input);
    }

    private static void validateFormat(String number) {
        if (!Pattern.matches(REGEX, number)) {
            throw new IllegalArgumentException("잘못된 숫자를 입력하셨습니다.");
        }
    }

    private void validateDuplicate(String number) {
        if (isDuplicated(number)) {
            throw new IllegalArgumentException("숫자에 중복된 수가 있습니다.");
        }
    }

    private boolean isDuplicated(String number) {
        String[] numbers = number.split("");
        Set<Integer> duplicateRemovedNumber = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        return numbers.length != duplicateRemovedNumber.size();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        User user = (User) object;
        return Objects.equals(input, user.input);
    }

    @Override
    public int hashCode() {
        return Objects.hash(input);
    }

}
