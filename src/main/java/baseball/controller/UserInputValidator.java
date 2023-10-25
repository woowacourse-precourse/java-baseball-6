package baseball.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserInputValidator {
    private static final String NULL_INPUT_MESSAGE = "null은 입력할 수 없습니다.";
    private static final int ANSWER_LENGTH = 3;
    private static final String WRONG_ANSWER_LENGTH_MESSAGE = "세 자리의 숫자를 입력해주세요.";
    private static final String WRONG_RANGE_STRING_MESSAGE = "한 자리는 1에서 9까지의 숫자만 입력할 수 있습니다.";
    private static final String DUPLICATED_STRING_MESSAGE = "세 자리 모두 서로 다른 숫자를 입력해주세요.";
    private static final String WRONG_RANGE_RESET_STRING_MESSAGE = "1 또는 2를 입력해주세요.";
    private static final char NUMERIC_RANGE_START_CHAR = '1';
    private static final char NUMERIC_RANGE_END_CHAR = '9';

    public String validateUserInputString(String userInputString) {
        if (userInputString == null) {
            throw new IllegalArgumentException(NULL_INPUT_MESSAGE);
        }
        return userInputString.replaceAll(" ", "");
    }

    public List<Integer> userInputNumbersValidate(String userInputString) {
        if (!isThreeNumbers(userInputString)) {
            throw new IllegalArgumentException(WRONG_ANSWER_LENGTH_MESSAGE);
        } else if (!isNumericCastable(userInputString)) {
            throw new IllegalArgumentException(WRONG_RANGE_STRING_MESSAGE);
        } else if (!isNotDuplicate(userInputString)) {
            throw new IllegalArgumentException(DUPLICATED_STRING_MESSAGE);
        }

        return convertStringToIntegerList(userInputString);
    }

    public int userInputRestartOrExitValidate(String userInputString) {
        if (!isOneOrTwo(userInputString)) {
            throw new IllegalArgumentException(WRONG_RANGE_RESET_STRING_MESSAGE);
        }
        return Integer.parseInt(userInputString);
    }

    public boolean isThreeNumbers(String userInputString) {
        if (userInputString.length() == ANSWER_LENGTH) {
            return true;
        }
        return false;
    }

    public boolean isNumericCastable(String userInputString) {
        for (int i = 0; i < userInputString.length(); i++) {
            if (!isOneToNine(userInputString.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isOneToNine(char inputChar) {
        if (inputChar < NUMERIC_RANGE_START_CHAR || inputChar > NUMERIC_RANGE_END_CHAR) {
            return false;
        }
        return true;
    }

    public boolean isOneOrTwo(String userInputString) {
        if (userInputString.equals("1") || userInputString.equals("2")) {
            return true;
        }
        return false;
    }

    public boolean isNotDuplicate(String userInputString) {
        String[] inputStringArray = userInputString.split("");
        Set<String> setString = Arrays.stream(inputStringArray).collect(Collectors.toSet());

        if (setString.size() == ANSWER_LENGTH) {
            return true;
        }
        return false;
    }

    public List<Integer> convertStringToIntegerList(String userInputString) {
        int[] convertedIntArray = Stream.of(userInputString.split("")).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(convertedIntArray).boxed().collect(Collectors.toList());
    }
}
