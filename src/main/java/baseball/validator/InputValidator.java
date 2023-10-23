package baseball.validator;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    private int startOfRange;
    private int endOfRange;
    private int digitCount;

    public InputValidator(int startOfRange, int endOfRange, int digitCount) {
        this.startOfRange = startOfRange;
        this.endOfRange = endOfRange;
        this.digitCount = digitCount;
    }

    public boolean isValidInput(String userInput) {
        return hasValidLength(userInput) &&
                hasOnlyDigits(userInput) &&
                isWithinRange(userInput) &&
                hasUniqueDigits(userInput);
    }

    private boolean hasValidLength(String userInput) {
        return userInput.length() == digitCount;
    }

    private boolean hasOnlyDigits(String userInput) {
        for (char ch : userInput.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    private boolean isWithinRange(String userInput) {
        for (char ch : userInput.toCharArray()) {
            int digit = Character.getNumericValue(ch);
            if (digit < startOfRange || digit > endOfRange) {
                return false;
            }
        }
        return true;
    }

    private boolean hasUniqueDigits(String userInput) {
        Set<Character> uniqueDigits = new HashSet<>();
        for (char ch : userInput.toCharArray()) {
            if (uniqueDigits.contains(ch)) {
                return false;
            }
            uniqueDigits.add(ch);
        }
        return true;
    }
}
