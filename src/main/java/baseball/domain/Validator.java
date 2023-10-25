package baseball.domain;

import java.util.List;

public class Validator {

    private static final String ERROR_NAN = "[ERROR] 숫자만 입력해주세요";
    private static final String ERROR_LENGTH = "[ERROR] 3개의 숫자를 입력해 주세요.";
    private static final String ERROR_RANGE = "[ERROR] 숫자의 범위는 1부터 9까지 입니다.";
    private static final String ERROR_DUPLICATE = "[ERROR] 중복되지 않은 숫자를 입력해주세요.";
    public static final String ERROR_NOT_PERMITTED = "[ERROR] 1 또는 2를 입력해주세요.";
    private static final String BASEBALL_RANGE = "[0-9]";
    private static final String NOT_ALLOWED = "0";
    private static final String END_OR_RESTART_RANGE = "[1-2]";
    private static final int MAX_LENGTH = 3;

    //모든 검증을 수행한다.
    public void validateStandard(List<String> userInput) {
        validateNumber(userInput);
        validateBallLength(userInput);
        validateNumberRange(userInput);
        validateDuplicate(userInput);
    }

    //입력이 숫자인지 검증
    public void validateNumber(List<String> userInput) {
        long error = userInput.stream().filter(this::isNumber).count();
        if (error != 0) {
            throw new IllegalArgumentException(ERROR_NAN);
        }
    }

    private boolean isNumber(String number) {
        return !number.matches(BASEBALL_RANGE);
    }

    //숫자의 갯수가 3개인지 검증
    public void validateBallLength(List<String> userInput) {
        if (userInput.size() != MAX_LENGTH) {
            throw new IllegalArgumentException(ERROR_LENGTH);
        }
    }

    //1 ~ 9의 범위인지 검증
    public void validateNumberRange(List<String> userInput) {
        if (userInput.contains(NOT_ALLOWED)) {
            throw new IllegalArgumentException(ERROR_RANGE);
        }
    }

    //중복된 숫자가 있는지 검증
    public void validateDuplicate(List<String> userInput) {
        if (userInput.stream().distinct().count() != userInput.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
    }

    //게임 종류 후 입력이 1또는 2인지 검증
    public int validateEndOrRestart(String userInput) {
        if (!userInput.matches(END_OR_RESTART_RANGE)) {
            throw new IllegalArgumentException(ERROR_NOT_PERMITTED);
        }
        return Integer.parseInt(userInput);
    }

}
