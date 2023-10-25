package baseball.controller;

import java.util.Arrays;
import java.util.HashSet;

public class Validator {

    private static final String PLEASE_INPUT_THREE_NUMBER = "3개의 양수를 입력해야합니다";
    private static final String PLEASE_INPUT_ONE_TO_NINE_NUMBER = "1-9사이의 숫자만 입력해야 합니다";
    private static final String PLEASE_INPUT_NOT_DUPLICATION = "중복되지 않는 3개의 양수를 입력해야합니다";
    private static final String PLEASE_INPUT_ONE_OR_TWO = "1혹은2만 입력해야합니다;";
    private static final String NUMBER_RANGE = "[1-9]+";
    private static final String RESTART_GAME_NUMBER = "1";
    private static final String GAME_END_NUMBER = "2";
    private static final int INPUT_NUMBER_SIZE = 3;


    public void validatePlayerInput(String playerInput) {
        String[] numbers = extractNumbers(playerInput);
        validateInputSize(numbers);
        validateInputContent(numbers);
        validateInputUniqueness(numbers);
    }

    private String[] extractNumbers(String playerInput) {
        return playerInput.replace(" ", "").split("");
    }

    private void validateInputSize(String[] numbers) {
        if (numbers.length != INPUT_NUMBER_SIZE) {
            throw new IllegalArgumentException(PLEASE_INPUT_THREE_NUMBER);
        }
    }

    private void validateInputContent(String[] numbers) {
        for (String number : numbers) {
            if (!number.matches(NUMBER_RANGE)) {
                throw new IllegalArgumentException(PLEASE_INPUT_ONE_TO_NINE_NUMBER);
            }
        }
    }

    private void validateInputUniqueness(String[] numbers) {
        HashSet<String> set = new HashSet<>(Arrays.asList(numbers));
        if (set.size() != INPUT_NUMBER_SIZE) {
            throw new IllegalArgumentException(PLEASE_INPUT_NOT_DUPLICATION);
        }
    }


    public void validateGameEndInput(String endnumber) {
        if (!endnumber.equals(RESTART_GAME_NUMBER) && !endnumber.equals(GAME_END_NUMBER)) {
            throw new IllegalArgumentException(PLEASE_INPUT_ONE_OR_TWO);
        }
    }

}
