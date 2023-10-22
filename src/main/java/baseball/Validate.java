package baseball;

import java.util.HashSet;

public class Validate {
    public static void isValidUserInput(String userInput) {
        if (checkInputLength(userInput)) {
            throw new IllegalArgumentException();
        }
        if (hasSameNumber(userInput)) {
            throw new IllegalArgumentException();
        }
        if (isInvalidDigitsOnly(userInput)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean checkInputLength(String userInput) {
        if (userInput.length() != 3) {
            return true;
        }
        return false;
    }

    public static boolean hasSameNumber(String userInput) {
        HashSet<Character> numberSet = new HashSet<Character>();
        for (int i = 0; i < userInput.length(); i++) {
            numberSet.add(userInput.charAt(i));
        }
        if (numberSet.size() != 3) {
            return true;
        }
        return false;
    }

    public static boolean isInvalidDigitsOnly(String userInput) {
        int startRange = '1';
        int endRange = '9';
        for (int i = 0; i < 3; i++) {
            int charTOASCII = userInput.charAt(i);
            if (startRange > charTOASCII) {
                return true;
            }
            if (endRange < charTOASCII) {
                return true;
            }
        }
        return false;
    }
}
