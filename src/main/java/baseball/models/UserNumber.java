package baseball.models;

import java.util.HashSet;
import java.util.Set;

public class UserNumber {
    private String userNumber;

    public UserNumber(String userNumber) {

        isStringLengthCorrect(userNumber);
        isDigitUserNumber(userNumber);
        isDifferentUserNumber(userNumber);

        this.userNumber = userNumber;

    }

    public String getUserNumber() {

        return userNumber;
    }

    public static void isStringLengthCorrect(String word) throws IllegalArgumentException {
        if (word.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(입력값 3자리수)");
        }
    }

    public static void isDigitUserNumber(String word) {
        for (int i = 0; i < word.length(); i++) {
            isDigitCharInString(word, i);
        }
    }

    public static void isDifferentUserNumber(String word) throws IllegalArgumentException {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            set.add(word.charAt(i));
        }
        if (set.size() != word.length()) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(중복된 숫자)");
        }
    }

    public static void isDigitCharInString(String word, int index) throws IllegalArgumentException {
        if (!Character.isDigit(word.charAt(index))) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(3자리 자연수가 아닙니다.)");
        }
    }
}
