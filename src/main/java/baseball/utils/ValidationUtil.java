package baseball.utils;

import java.util.Arrays;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ValidationUtil {
    private static final String INPUT_LENGTH_ERROR_MESSAGE = "입력 값의 길이는 3입니다.";
    private static final String NOT_NUMBER_ERROR_MESSAGE = "숫자만 입력 가능합니다.";
    private static final String NUMBER_RANGE_ERROR_MESSAGE = "1 부터 9 사이의 숫자만 입력 가능합니다.";
    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "중복된 숫자는 입력할 수 없습니다.";
    private static final String RESTART_ERROR_MESSAGE = "1 또는 2만 입력될 수 있습니다.";

    private static final int POSSIBLE_NUMBER_LENGTH = 3;
    private static final String RESTART_GAME_OPTION = "1";
    private static final String END_GAME_OPTION = "2";

    private static final String REGEXP_ONLY_NUMBER = "^[\\d]*$";
    private static final String REGEXP_NUMBER_RANGE = "^[1-9]*$";

    public void playerInputValidator(String playerInput) {
        if (!isLengthThree(playerInput)) {
            throw new IllegalArgumentException(INPUT_LENGTH_ERROR_MESSAGE);
        }
        if (!isNumber(playerInput)) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    public void savaNumberValidator(String playerNumber) {
        if (!isCorrectNumberRange(playerNumber)) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
        }
        if (!containDuplicateNumber(playerNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }

    public void restartGameValidator(String input) {
        if (!isOneOrTwo(input)) {
            throw new IllegalArgumentException(RESTART_ERROR_MESSAGE);
        }
    }

    public boolean isLengthThree(String input) {
        return input.length() == POSSIBLE_NUMBER_LENGTH;
    }

    public boolean isNumber(String input) {
        return Pattern.matches(REGEXP_ONLY_NUMBER, input);
    }

    public boolean isCorrectNumberRange(String input) {
        return Pattern.matches(REGEXP_NUMBER_RANGE, input);
    }

    public boolean containDuplicateNumber(String input) {
        String[] numbers = input.split("");
        Set<String> numberSet = Arrays.stream(numbers).collect(Collectors.toSet());

        return numberSet.size() == POSSIBLE_NUMBER_LENGTH;
    }

    public boolean isOneOrTwo(String input) {
        return input.equals(RESTART_GAME_OPTION) || input.equals(END_GAME_OPTION);
    }
}
