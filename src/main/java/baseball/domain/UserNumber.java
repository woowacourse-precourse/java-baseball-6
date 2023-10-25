package baseball.domain;

import baseball.constant.Constant;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserNumber {

    private final List<Integer> userNumber;

    public UserNumber(String input) {
        List<Integer> userNumberList = createUserNumber(input);
        validateUserNumberLength(userNumberList);
        validateUserNumberRange(userNumberList);
        validateUserNumberDuplicate(userNumberList);
        this.userNumber = userNumberList;
    }

    private List<Integer> createUserNumber(String input) {
        return Arrays.stream(input.split(""))
                .map(UserNumber::validateUserNumberInteger)
                .toList();
    }

    private static int validateUserNumberInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUserNumberLength(List<Integer> userNum) {
        if (userNum.size() != Constant.ZERO_NUMBER && userNum.size() != Constant.LENGTH_LIMIT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUserNumberRange(List<Integer> userNum) {
        if (userNum.stream().anyMatch(num -> Constant.START_NUMBER > num || num > Constant.END_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUserNumberDuplicate(List<Integer> userNum) {
        if (userNum.stream().distinct().count() != Constant.LENGTH_LIMIT) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getUserNumber() {
        return Collections.unmodifiableList(userNumber);
    }
}
