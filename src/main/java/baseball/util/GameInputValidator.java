package baseball.util;

import java.util.regex.Pattern;

public class GameInputValidator extends Validator{
    private static final Pattern GAME_NUMBER_REGEX = Pattern.compile("^[1-9]{3}$");

    @Override
    public void validate(String inputNum) throws IllegalArgumentException {
        // 공백 제거
        String gameInputNum = removeSpace(inputNum);
        validateEmptyInput(gameInputNum);
        validateGameInputNum(gameInputNum);
    }

    private void validateGameInputNum(String gameInputNum) throws IllegalArgumentException{
        if(!GAME_NUMBER_REGEX.matcher(gameInputNum).matches()) {
            throw new IllegalArgumentException("Exception Message : 숫자야구 입력 형식에 맞춰주세요.");
        }
    }
}
