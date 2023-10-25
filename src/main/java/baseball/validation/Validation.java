package baseball.validation;

import java.util.HashSet;
import java.util.Set;

public class Validation {

    public void runValidation(char[] data, int dataType) {
        validateSize(data, dataType);
        validateNumber(data, dataType);
        validateDuplicate(data, dataType);
        validateRestartValue(data, dataType);
    }

    // 올바른 사이즈인지 확인합니다.
    private void validateSize(char[] target, int inputType) {
        if (target.length != inputType) {
            throw new IllegalArgumentException(inputType + ErrorMessage.INVALID_SIZE.getMessage());
        }
    }

    // 1~9의 숫자인지 확인합니다.
    private void validateNumber(char[] target, int dataType) {
        if (dataType == 1) {
            return;
        }
        for (char chr : target) {
            isDigit(chr);
            hasZero(chr);
        }
    }

    private void isDigit(char target) {
        if (!Character.isDigit(target)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TYPE.getMessage());
        }
    }

    private void hasZero(char target) {
        if (target - '0' == 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.getMessage());
        }
    }

    // 같은 숫자가 있는지 확인합니다.
    private void validateDuplicate(char[] target, int inputType) {
        if (inputType == 1) {
            return;
        }
        Set<Character> checkDuplicateValue = new HashSet<>();
        for (char chr : target) {
            checkDuplicateValue.add(chr);
        }
        if (checkDuplicateValue.size() != 3) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATE.getMessage());
        }
    }

    // 게임 재시작 값인 '1', '2' 인지 확인합니다.
    private void validateRestartValue(char[] target, int inputType) {
        if (inputType == 3) {
            return;
        }
        if (!(target[0] == ('1')) && !(target[0] == ('2'))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VALUE.getMessage());
        }
    }
}