package baseball.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class UserNumberChecker {

    private String userNumber;

    public String getUserNumber() {
        return userNumber;
    }

    public void updateUserNumber(String userNumber) {
        isLengthCorrect(userNumber);
        isSingleDigit(userNumber);
        isDuplicatedNumber(userNumber);

        this.userNumber = userNumber;
    }

    public static void isLengthCorrect(String userNumber) throws IllegalArgumentException {
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException("에러! 총 세 번 입력해야 합니다.)");
        }
    }

    public static void isSingleDigit(String userNumber) throws IllegalArgumentException {
        for (char digit : userNumber.toCharArray()) {
            if (!Character.isDigit(digit) || digit == '0') {
                throw new IllegalArgumentException("에러! 1부터 9까지의 숫자만 입력할 수 있습니다.");
            }
        }
    }

    public static void isDuplicatedNumber(String userNumber) throws IllegalArgumentException {
        Set<Character> digitSet = new LinkedHashSet<>();

        for (char digit : userNumber.toCharArray()) {
            if (!digitSet.add(digit)) {
                throw new IllegalArgumentException("에러! 중복된 숫자를 입력할 수 없습니다.");
            }
        }
    }
}