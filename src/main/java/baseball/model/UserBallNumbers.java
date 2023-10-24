package baseball.model;

import static baseball.common.Constant.VALID_INPUT_SIZE;
import static baseball.common.Constant.ZERO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserBallNumbers {
    private final List<Integer> userBallNumbers;

    private UserBallNumbers(List<Integer> inputNumbers) {
        if (!this.validate(inputNumbers)) {
            throw new IllegalArgumentException("유효한 값이 아닙니다.");
        }
        this.userBallNumbers = inputNumbers;
    }

    public static UserBallNumbers of(String input) {
        return new UserBallNumbers(hundredsIntToList(input));
    }

    private static List<Integer> hundredsIntToList(String number) {
        return Arrays.stream(number.split("")).map(Integer::valueOf).collect(Collectors.toList());
    }

    private boolean validate(List<Integer> numbers) {
        return validateLength(numbers) && validateNoneZero(numbers) && validateUnique(numbers);
    }

    private boolean validateLength(List<Integer> numbers) {
        return numbers.size() == VALID_INPUT_SIZE;
    }

    private boolean validateUnique(List<Integer> numbers) {
        return numbers.stream().noneMatch(n -> numbers.indexOf(n) != numbers.lastIndexOf(n));
    }

    private boolean validateNoneZero(List<Integer> numbers) {
        return !numbers.contains(ZERO);
    }

    public List<Integer> getUserBallNumbers() {
        return userBallNumbers;
    }
}
