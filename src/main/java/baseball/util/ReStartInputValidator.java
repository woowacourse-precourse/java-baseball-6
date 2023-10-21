package baseball.util;

import java.util.regex.Pattern;

public class ReStartInputValidator extends Validator{
    private static final Pattern RESTART_NUMBER_REGEX = Pattern.compile("^[1-2]{1}$");

    @Override
    public void validate(String inputRestartNum) throws IllegalArgumentException {
        String afterNum = removeSpace(inputRestartNum);
        validateEmptyInput(afterNum);
        validateReStartInputNum(afterNum);
    }

    private void validateReStartInputNum(String reStartNum) throws IllegalArgumentException{
        if(!RESTART_NUMBER_REGEX.matcher(reStartNum).matches()) {
            throw new IllegalArgumentException("Exception Message : 재시작 입력값의 형식에 맞춰주세요.");
        }
    }
}
