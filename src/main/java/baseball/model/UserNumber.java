package baseball.model;

import java.util.HashSet;
import java.util.Set;

public class UserNumber {
    private final String userNumber;

    public UserNumber(String userNumber, int numberSize) {
        checkIsDigit(userNumber);
        checkNumberSize(userNumber, numberSize);
        checkNotDuplicate(userNumber);

        this.userNumber = userNumber;
    }

    public String getUserNumber() {
        return userNumber;
    }

    /**
     * 숫자가 아닐 경우 예외 발생
     */
    public static void checkIsDigit(String inputWord) {
        for (int i = 0; i < inputWord.length(); i++) {
            isDigitNumber(inputWord, i);
        }
    }

    public static void isDigitNumber(String inputWord, int idx) {
        if (!Character.isDigit(inputWord.charAt(idx))) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    /**
     * 자리수가 맞지 않을 경우 예외 발생
     */
    public static void checkNumberSize(String inputWord, int numberSize) {
        if (inputWord.length() != numberSize) {
            throw new IllegalArgumentException("세자리 숫자가 아닙니다.");
        }
    }

    /**
     * 중복된 숫자가 있을 경우 예외 발생
     */
    public static void checkNotDuplicate(String inputWord) {
        Set<String> inputWordSet = new HashSet<>();
        for (int i = 0; i < inputWord.length(); i++) {
            inputWordSet.add(String.valueOf(inputWord.charAt(i)));
        }
        if (inputWord.length() != inputWordSet.size()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }
}
