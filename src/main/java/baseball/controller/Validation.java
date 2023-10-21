package baseball.controller;

import baseball.Configuration;
import java.util.List;

public class Validation {

    int CONTINUE = Configuration.CONTINUE;
    int END = Configuration.END;
    int MIN_NUM = Configuration.MIN_NUM;
    int MAX_NUM = Configuration.MAX_NUM;

    public void validateInputLength(String input, int value) {
        if (input.length() != value) {
            throw new IllegalArgumentException(value + " 자리를 입력해야 합니다.");
        }
    }

    public void validateOneOrTwo(int inputNum) {

        if (inputNum != CONTINUE && inputNum != END) {
            throw new IllegalArgumentException("1 또는 2 만 입력해야 합니다.");
        }
    }

    public void validateNumber(int inputNum) {
        if (inputNum < MIN_NUM || inputNum > MAX_NUM) {
            throw new IllegalArgumentException("1 ~ 9 범위의 숫자만 입력해야 합니다.");
        }
    }

    public void validateDuplication(List<Integer> inputList, int inputNum) {
        if (inputList.contains(inputNum)) {
            throw new IllegalArgumentException("중복되지 않는 숫자를 입력해야 합니다.");
        }
    }
}
