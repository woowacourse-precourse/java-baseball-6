package model;

import java.util.*;
import java.util.regex.Pattern;
public class Exception {
    static final String IS_NUMBER = "[ERROR] 숫자를 입력하세요.";
    static final String NUMBER_VALID = "[ERROR] 1 ~ 9 사이의 숫자를 입력하세요.";
    static final String THREE_NUMBER = "[ERROR] 숫자를 3개 입력하세요.";
    static final String OTHER_NUMBER = "[ERROR] 서로 다른 숫자 3개를 입력하세요.";
    static final String ONE_NUMBER = "[ERROR] 숫자를 1개 입력하세요.";
    static final String RETRY_NUMBER = "[ERROR] 1 또는 2를 입력하세요.";

    // 입력받은 타입이 숫자인지 확인
    private void checkNumberType(String input) {
        String regex = "[0-9]+";

        if (!Pattern.matches(regex, input)) {
            throw new IllegalArgumentException(IS_NUMBER);
        }
    }

    // 1에서 9 사이의 숫자인지 확인
    private void checkNumberRange(int input) {
        if (input < NumberData.MIN_NUMBER || input > NumberData.MAX_NUMBER) {
            throw new IllegalArgumentException(NUMBER_VALID);
        }
    }

    // 숫자를 3개 입력했는지 확인
    private void checkThreeNumber(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(THREE_NUMBER);
        }
    }

    // 숫자를 하나만 입력했는지
    private void checkOneNumber(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException(ONE_NUMBER);
        }
    }

    // 중복된 숫자가 없는지 확인
    private void checkDuplication(String input) {
        HashSet<String> numSet = new HashSet<>(List.of(input.split("")));
        if (numSet.size() != 3) {
            throw new IllegalArgumentException(OTHER_NUMBER);
        }
    }

    // 1과 2중 하나를 입력했는지 확인
    private void checkRetryNumber(int input) {
        if (input != NumberData.RESTART_NUMBER && input != NumberData.FINISH_NUMBER) {
            throw new IllegalArgumentException(RETRY_NUMBER);
        }
    }
}
