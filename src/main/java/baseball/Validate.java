package baseball;

import java.util.HashSet;

public class Validate {
    public static boolean isValidUserInput(String userInput) {
        if (checkInputLength(userInput)) {
            throw new IllegalArgumentException();
        }
        if (hasSameNumber(userInput)) {
            throw new IllegalArgumentException();
        }
        if (isInvalidDigitsOnly(userInput)) {
            throw new IllegalArgumentException();
        }
        return true;
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
        for (int i = 0; i < 3; i++) {
            if (Character.getNumericValue('1') > userInput.charAt(i)) {
                return true;
            }
            if (Character.getNumericValue('9') < userInput.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}
