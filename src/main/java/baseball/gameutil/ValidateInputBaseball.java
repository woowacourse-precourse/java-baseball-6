package baseball.gameutil;

import baseball.message.MessageString;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidateInputBaseball implements ValidateInput {

    @Override
    public String validateGameInput(String input) {
        if (!checkLength(input, Constant.NUMBER_LENGTH)) {
            throw new IllegalArgumentException(MessageString.GAME_LEN_ERROR_STRING);
        }
        if (!checkIsAllNumber(input)) {
            throw new IllegalArgumentException(MessageString.WRONG_GAME_INPUT_ERROR_STRING);
        }
        if (!checkBetween(input, Constant.NUMBER_MIN, Constant.NUMBER_MAX)) {
            throw new IllegalArgumentException(MessageString.WRONG_GAME_INPUT_ERROR_STRING);
        }
        if (!checkUnique(input)) {
            throw new IllegalArgumentException(MessageString.WRONG_GAME_INPUT_ERROR_STRING);
        }
        return input;
    }

    @Override
    public String validateRerunInput(String input) {
        if (!checkLength(input, Constant.RESTART_MODE_LENGTH)) {
            throw new IllegalArgumentException(MessageString.WRONG_RERUN_INPUT_ERROR_STRING);
        }
        if (!checkIsAllNumber(input)) {
            throw new IllegalArgumentException(MessageString.WRONG_RERUN_INPUT_ERROR_STRING);
        }
        if (!checkBetween(input, Constant.RESTART_RESTART, Constant.RESTART_END)) {
            throw new IllegalArgumentException(MessageString.WRONG_RERUN_INPUT_ERROR_STRING);
        }
        return input;
    }

    private Boolean checkLength(String input, Integer expectedLength) {
        if (input.length() != expectedLength) {
            return false;
        }
        return true;
    }

    private Boolean checkIsAllNumber(String input) {
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    private Boolean checkBetween(String input, Integer start, Integer end) {
        for (char ch : input.toCharArray()) {
            int number = Character.getNumericValue(ch);
            if (start > number || number > end) {
                return false;
            }
        }
        return true;
    }

    private Boolean checkUnique(String input) {
        Set<Character> inputSet = new HashSet<>();
        for (char c : input.toCharArray()) {
            inputSet.add(c);
        }

        return inputSet.size() == input.length();
    }

}
