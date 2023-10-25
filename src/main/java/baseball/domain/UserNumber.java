package baseball.domain;

import baseball.constant.Constant;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserNumber {

    private final List<Integer> userNumber;

    public UserNumber(String input) {
        List<Integer> userNumberList = createUserNumber(input);
        validateUserInputLength(userNumberList);
        validateUserInputRange(userNumberList);
        validateUserInputDuplicate(userNumberList);
        this.userNumber = userNumberList;
    }

    private List<Integer> createUserNumber(String input) {
        return Arrays.stream(input.split(""))
                .map(UserNumber::validateUserInputNumber)
                .collect(Collectors.toList());
    }

    private static int validateUserInputNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUserInputLength(List<Integer> userNum) {
        if (userNum.size() != Constant.ZERO_NUMBER && userNum.size() != Constant.NUMBER_LENGTH_LIMIT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUserInputRange(List<Integer> userNum) {
        if (userNum.stream().anyMatch(num -> Constant.START_NUMBER > num || num > Constant.END_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUserInputDuplicate(List<Integer> userNum) {
        if (userNum.stream().distinct().count() != Constant.NUMBER_LENGTH_LIMIT) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getUserNumber() {
        return Collections.unmodifiableList(userNumber);
    }
}
