package baseball.validator;

import static baseball.constant.BaseballConstant.BASEBALL_MAX_NUMBER;
import static baseball.constant.BaseballConstant.BASEBALL_MIN_NUMBER;
import static baseball.constant.BaseballConstant.BASEBALL_NUMBERS_SIZE;

import java.util.HashSet;
import java.util.Set;

public class BaseballValidator {

    private static final String INVALID_NUMBER_MESSAGE = "숫자를 입력해주세요.";
    private static final String INVALID_SIZE_MESSAGE = "허용되지 않는 자릿수입니다.";
    private static final String INVALID_RANGE_MESSAGE = "숫자 입력 범위를 벗어났습니다.";
    private static final String INVALID_DUPLICATE_MESSAGE = "입력한 숫자에 중복이 있습니다.";

    public void validate(String number) {
        validateInteger(number);
        validateSize(number);
        validateRange(number);
        validateDuplicate(number);
    }

    private void validateInteger(String number) {
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (!isNumber(c)) {
                throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
            }
        }
    }

    private void validateSize(String number) {
        if (isValidateSize(number)) {
            throw new IllegalArgumentException(INVALID_SIZE_MESSAGE);
        }
    }

    private void validateRange(String number) {
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (!isValidateRange(c)) {
                throw new IllegalArgumentException(INVALID_RANGE_MESSAGE);
            }
        }
    }

    private void validateDuplicate(String number) {
        StringBuilder sb = new StringBuilder();
        Set<Character> numSet = new HashSet<>();

        for (char c : number.toCharArray()) {
            if (numSet.add(c)) {
                sb.append(c);
            }
        }

        if (number.length() != sb.length()) {
            throw new IllegalArgumentException(INVALID_DUPLICATE_MESSAGE);
        }
    }

    private boolean isValidateRange(char c) {
        int targetNumber = Character.getNumericValue(c);
        return BASEBALL_MIN_NUMBER <= targetNumber && targetNumber <= BASEBALL_MAX_NUMBER;
    }

    private boolean isValidateSize(String number) {
        return number.length() != BASEBALL_NUMBERS_SIZE;
    }

    private boolean isNumber(char c) {
        return Character.isDigit(c);
    }
}
