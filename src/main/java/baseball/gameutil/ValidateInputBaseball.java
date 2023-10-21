package baseball.gameutil;

import baseball.message.ErrorMessage;

public class ValidateInputBaseball implements ValidateInput {

    @Override
    public String validateGameInput(String input) {
        if(!checkLength(input, 3))
            throw new IllegalArgumentException(ErrorMessage.gameLenError);
        if(!checkIsAllNumber(input))
            throw new IllegalArgumentException(ErrorMessage.wrongGameInputError);
        if(!checkBetween(input, 1, 9))
            throw new IllegalArgumentException(ErrorMessage.wrongGameInputError);
        return input;
    }

    @Override
    public String validateRerunInput(String input) {
        if(!checkLength(input, 1))
            throw new IllegalArgumentException(ErrorMessage.wrongRerunInputError);
        if(!checkIsAllNumber(input))
            throw new IllegalArgumentException(ErrorMessage.wrongRerunInputError);
        if(!checkBetween(input, 1, 2))
            throw new IllegalArgumentException(ErrorMessage.wrongRerunInputError);
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
