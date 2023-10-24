package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class UserValue {
    private static String userNumberString;

    public static int getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Integer.parseInt(Console.readLine());
    }

    public static void validateNumber(int userNumber) {
        validateIsThreeDigitNumber(userNumber);
        validateNoDuplicateDigits(userNumber);
        validateNoZeroDigits();
    }

    static void validateIsThreeDigitNumber(int userNumber) {
        if (userNumber < 100 || userNumber > 999) {
            throw new IllegalArgumentException();
        }
    }

    static void validateNoDuplicateDigits(int userNumber) {
        userNumberString = String.valueOf(userNumber);
        Set<Character> digits = new HashSet<>();

        for (char digit : userNumberString.toCharArray()) {
            if (!Character.isDigit(digit) || !digits.add(digit)) {
                throw new IllegalArgumentException();
            }
        }
    }

    static void validateNoZeroDigits() {
        if (userNumberString.contains("0")) {
            throw new IllegalArgumentException();
        }
    }
}
