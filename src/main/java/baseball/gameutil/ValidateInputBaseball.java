package baseball.gameutil;

import baseball.message.MessageString;

public class ValidateInputBaseball implements ValidateInput {

    @Override
    public String validateGameInput(String input) {
        if(!checkLength(input, Constant.NUMBER_LENGTH))
            throw new IllegalArgumentException(MessageString.GAME_LEN_ERROR_STRING);
        if(!checkIsAllNumber(input))
            throw new IllegalArgumentException(MessageString.WRONG_GAME_INPUT_ERROR_STRING);
        if(!checkBetween(input, Constant.NUMBER_MIN, Constant.NUMBER_MAX))
            throw new IllegalArgumentException(MessageString.WRONG_GAME_INPUT_ERROR_STRING);
        return input;
    }

    @Override
    public String validateRerunInput(String input) {
        if(!checkLength(input, Constant.RESTART_MODE_LENGTH))
            throw new IllegalArgumentException(MessageString.WRONG_RERUN_INPUT_ERROR_STRING);
        if(!checkIsAllNumber(input))
            throw new IllegalArgumentException(MessageString.WRONG_RERUN_INPUT_ERROR_STRING);
        if(!checkBetween(input, Constant.RESTART_MIN, Constant.RESTART_MAX))
            throw new IllegalArgumentException(MessageString.WRONG_RERUN_INPUT_ERROR_STRING);
        return input;
    }

    private Boolean checkLength(String input, Integer expectedLength) {
        if (input.length() != expectedLength)
            return Boolean.FALSE;
        return Boolean.TRUE;
    }

    private Boolean checkIsAllNumber(String input) {
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    private Boolean checkBetween(String input, Integer start, Integer end) {
        for (char ch : input.toCharArray()) {
            int number = Character.getNumericValue(ch);
            if (start > number || number > end) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }


}
