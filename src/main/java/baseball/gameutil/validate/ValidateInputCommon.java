package baseball.gameutil.validate;

import java.util.HashSet;
import java.util.Set;

public class ValidateInputCommon {
    public boolean checkLength(String input, Integer expectedLength) {
        return input.length() == expectedLength;
    }

    public boolean checkIsAllNumber(String input) {
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkBetween(String input, Integer start, Integer end) {
        for (char ch : input.toCharArray()) {
            int number = Character.getNumericValue(ch);
            if (start > number || number > end) {
                return false;
            }
        }
        return true;
    }

    public boolean checkUnique(String input) {
        Set<Character> inputSet = new HashSet<>();
        for (char c : input.toCharArray()) {
            inputSet.add(c);
        }

        return inputSet.size() == input.length();
    }
}
