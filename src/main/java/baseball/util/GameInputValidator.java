package baseball.util;

import java.util.regex.Pattern;

public class GameInputValidator extends Validator{
    private static final Pattern GAME_NUMBER_REGEX = Pattern.compile("^[1-9]{3}$");

    @Override
    public void validate(String inputNum) throws IllegalArgumentException {
        // 공백 제거
        String gameInputNum = removeSpace(inputNum);
        validateEmptyInput(gameInputNum);
        checkNumLengthThree(gameInputNum);
        checkEachNumNotSame(gameInputNum);
    }

    private void checkNumLengthThree(String gameInputNum) throws IllegalArgumentException {
        if(!GAME_NUMBER_REGEX.matcher(gameInputNum).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_GAME_INPUT_NUM.getErrorMessage());
        }

    }

    private void checkEachNumNotSame(String gameInputNum) throws IllegalArgumentException {
        if (gameInputNum.chars().distinct().count() != 3) {
            throw new IllegalArgumentException(ErrorMessage.SAME_INPUT_NUM.getErrorMessage());
        }
    }
}
