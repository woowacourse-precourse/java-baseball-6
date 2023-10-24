package util;

import java.util.HashSet;
import java.util.Set;

public class ValidationCheck {
    private static final int NUMBER_SIZE = 3;
    private static final String RE_NUMBER_REGEX = "[1-2]";
    private static final int RE_NUMBER_SIZE = 1;

    public void checkUserInput(String userInput) {
        if (userInput.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자는 3개까지만 입력할 수 있습니다.");
        }

        for (int i = 0; i < userInput.length(); i++) {
            if (!userInput.matches("[1-9]+")) {
                throw new IllegalArgumentException("1~9 범위 내의 '숫자'만 입력할 수 있습니다.");
            }
        }

        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < userInput.length(); i++) {
            numSet.add(userInput.charAt(i) - '0');
        }
        if (numSet.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("같은 숫자는 입력할 수 없습니다.");
        }
    }

    public void selectReplayOrQuitGameException(String numberCasesOfString) {
        notOneDigitNumberCase(numberCasesOfString); // 숫자의 개수 예외
        notRangeOfNumberCase(numberCasesOfString); // 숫자의 종류 예외
    }

    //숫자의 개수가 1개가 아닌 경우
    public void notOneDigitNumberCase(String numberCasesOfString) {
        if (numberCasesOfString.length() != RE_NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자는 1개만 입력하셔야 합니다.");
        }
    }

    //숫자의 종류가 1,2가 아닌 경우
    public void notRangeOfNumberCase(String numberCasesOfString) {
        if (!numberCasesOfString.matches(RE_NUMBER_REGEX)) {
            throw new IllegalArgumentException("1,2의 수 중 하나만을 입력해야 합니다.");
        }
    }
}
