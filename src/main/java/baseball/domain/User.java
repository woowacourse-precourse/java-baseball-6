package baseball.domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class User {

    public static final String DELIMITER = "";

    private final String input;

    public User(String number, Rule rule) {
        validate(number, rule);
        this.input = number;
    }

    public void validate(String number, Rule rule) {
        final int numCount = rule.digits();
        final String regex = String.format("^[1-9]{%d}$", numCount);

        validateInput(number, regex);
    }

    private void validateInput(String number, String regex) {
        validateFormat(number, regex);
        validateDuplicate(number);
    }

    private static void validateFormat(String number, String regex) {
        if (!Pattern.matches(regex, number)) {
            throw new IllegalArgumentException("잘못된 숫자를 입력하셨습니다.");
        }
    }

    private void validateDuplicate(String number) {
        if (isDuplicated(number)) {
            throw new IllegalArgumentException("숫자에 중복된 수가 있습니다.");
        }
    }

    private boolean isDuplicated(String number) {
        String[] numbers = number.split(DELIMITER);
        Set<Integer> duplicateRemovedNumber = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        return numbers.length != duplicateRemovedNumber.size();
    }

    public boolean isStrike(int number, int index) {
        return this.contains(number) && this.isSamePosition(number, index);
    }

    public boolean isBall(int number, int index) {
        return this.contains(number) && !this.isSamePosition(number, index);
    }

    private boolean contains(int number) {
        return input.contains(String.valueOf(number));
    }

    private boolean isSamePosition(int number, int index) {
        return input.charAt(index) == String.valueOf(number).charAt(0);
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
