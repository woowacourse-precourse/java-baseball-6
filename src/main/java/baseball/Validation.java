package baseball;

import java.util.HashSet;

public class Validation {
    public void inputLengthCheck(String userInput) {
        if (userInput.length() != Constant.INPUT_LENGTH) {
            throw new IllegalArgumentException("입력이 필요한 값의 길이는 3입니다.");
        }
    }

    public void inputRangeCheck(String userInput) {
        for (int i = 0; i < Constant.INPUT_LENGTH; i++) {
            if (userInput.charAt(i) - '0' > Constant.END_RANGE && userInput.charAt(i) - '0' < Constant.START_RANGE) {
                throw new IllegalArgumentException("입력 값의 범위는 123 ~ 987 입니다.");
            }
        }
    }

    public void inputDuplicateCheck(String userInput) {
        HashSet<Character> duplicateCheck = new HashSet<>();
        for (int i = 0; i < Constant.INPUT_LENGTH; i++) {
            duplicateCheck.add(userInput.charAt(i));
        }
        if (duplicateCheck.size() != Constant.INPUT_LENGTH) {
            throw new IllegalArgumentException("입력 값은 중복이 허용되지 않습니다.");
        }
    }

    public void restartCheck(String restartNum) {
        if (!(restartNum.equals(Constant.RESTART_NUM) || restartNum.equals(Constant.EXIT_NUM))) {
            throw new IllegalArgumentException("재시작(1) 혹은 종료(2) 입력이 필요합니다.");
        }
    }
}