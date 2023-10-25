package baseball.model;

import java.util.Arrays;
import java.util.HashSet;

import static baseball.model.Constants.GAME_NUMBER_LENGTH;

public class Validator {

    /**
     * 사용자 입력값 유효성 검사
     * (1)3글자인지 (2)정수인지 (3)중복숫자가 없는지
     * @param userNumber
     * @return 유효성 검사 결과 true/false
     */
    public boolean isValidNumber(String userNumber) {
        if (isInteger(userNumber) && isValidLength(userNumber, GAME_NUMBER_LENGTH) && isNotNumberRepeat(userNumber)) {
            return true;
        }
        return false;
    }

    private boolean isValidLength(String userNumber, Integer length) {
        if (userNumber.length() == GAME_NUMBER_LENGTH) {
            return true;
        }
        return false;
    }


    private boolean isInteger(String userNumber) {
        if (userNumber.matches(Constants.INTEGER_REGEX)) {
            return true;
        }
        return false;
    }

    private boolean isNotNumberRepeat(String userNumber) {
        HashSet<String> setNumber = new HashSet<>(
                Arrays.asList(userNumber.split(""))
        );
        if (setNumber.size() != GAME_NUMBER_LENGTH) {
            return false;
        }
        return true;
    }

    public void validateRestartOrEndNumber(String restartOrEndNumber) throws IllegalArgumentException{
        if (!isInteger(restartOrEndNumber) && !isValidLength(restartOrEndNumber, 1) && !isOneOrTwo(restartOrEndNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private Boolean isOneOrTwo(String restartOrEndNumber) {
        if (Integer.parseInt(restartOrEndNumber) == 1 || Integer.parseInt(restartOrEndNumber) == 2) {
            return true;
        }
        return false;
    }
}
