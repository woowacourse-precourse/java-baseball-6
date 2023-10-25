package baseball.util;

import static baseball.util.ConvertInputToArr.inputToArr;

import java.util.Arrays;

public class Validation implements Validate {

    public final static int EXPECTED_LENGTH = 3;
    private final static int EXPECTED_RETRY_LENGTH = 1;
    private final static String GAME_REPLAY = "1";
    private final static String GAME_EXIT = "2";
    private final static String WRONG_INPUT_MESSAGE = "잘못된 입력입니다.";

    @Override
    public boolean combinedValidation(String input) {
        if (validateInputType(input) && validateInputLength(input, EXPECTED_LENGTH)
                && validationEachDifferentElement(input)) {
            return true;
        }
        throw new IllegalArgumentException(WRONG_INPUT_MESSAGE);
    }

    @Override
    public boolean validationReplayInput(String input) {
        if (validateInputType(input) && validateInputLength(input, EXPECTED_RETRY_LENGTH)) {
            if (input.equals(GAME_REPLAY) || (input.equals(GAME_EXIT))) {
                return true;
            }
        }
        throw new IllegalArgumentException(WRONG_INPUT_MESSAGE);
    }

    /**
     * false : 입력된 값에 숫자 외의 포함될 경우 && validate(0) 문자가 포함되어 있을 경우
     */
    @Override
    public boolean validateInputType(String input) {
        for (int i = 0; i < input.length(); i++) {
            char charAt = input.charAt(i);
            if (!(Character.isDigit(charAt) && validateEqualInput(charAt, '0'))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean validateInputLength(String input, int expectedLength) {
        return input.length() == expectedLength;
    }

    @Override
    public boolean validateEqualInput(char input, char validate) {
        return input != validate;
    }

    @Override
    public boolean validationEachDifferentElement(String input) {
        int[] intArr = inputToArr(input);

        return Arrays.stream(intArr).distinct().count() == EXPECTED_LENGTH;
    }
}