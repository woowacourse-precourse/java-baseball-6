package baseball.utility;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputValidation {
    private static final int GAME_RULE_NUMBER_LENGTH = 3;
    private static final char GAME_RULE_NUMBER_CHAR_MIN = '1';
    private static final char GAME_RULE_NUMBER_CHAR_MAX = '9';
    private static final String ERROR_MESSAGE_LENGTH = "세 자릿 수가 아닙니다.";
    private static final String ERROR_MESSAGE_RANGE = "1 ~ 9 범위에 벗어난 값이 포함되어 있습니다.";
    private static final String ERROR_MESSAGE_DUPLICATE = "중복된 수가 포함되어 있습니다.";

    public List<Integer> ValidateNumber(String inputString) {
        if (!isTreeChar(inputString)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LENGTH);
        } else if (!isCharInRange(inputString)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_RANGE);
        } else if (!isNotDouble(inputString)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATE);
        }
        return convertStrToIntList(inputString);
    }
    public boolean isTreeChar(String inputString) {
        return inputString.length() == GAME_RULE_NUMBER_LENGTH;
    }
    public boolean isCharInRange(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            if (!isCheckInRange(inputString.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    private boolean isCheckInRange(char checkChar) {
        return checkChar >= GAME_RULE_NUMBER_CHAR_MIN && checkChar <= GAME_RULE_NUMBER_CHAR_MAX;
    }
    public boolean isNotDouble(String inputString) {
        String[] numbers = inputString.split("");
        Set<String> setNumbers = Arrays.stream(numbers).collect(Collectors.toSet());

        return setNumbers.size() == GAME_RULE_NUMBER_LENGTH;
    }
    public List<Integer> convertStrToIntList(String inputString) {
        int[] toIntList = Stream.of(inputString.split("")).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(toIntList).boxed().collect(Collectors.toList());
    }
}