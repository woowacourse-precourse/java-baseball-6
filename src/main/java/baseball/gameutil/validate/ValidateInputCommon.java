package baseball.gameutil.validate;

import java.util.HashSet;
import java.util.Set;

public class ValidateInputCommon {
    public Boolean checkLength(String input, Integer expectedLength) {
        if (input.length() != expectedLength) {
            return false;
        }
        return true;
    }

    public Boolean checkIsAllNumber(String input) {
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    public Boolean checkBetween(String input, Integer start, Integer end) {
        for (char ch : input.toCharArray()) {
            int number = Character.getNumericValue(ch);
            if (start > number || number > end) {
                return false;
            }
        }
        return true;
    }

    public Boolean checkUnique(String input) {
        Set<Character> inputSet = new HashSet<>();
        for (char c : input.toCharArray()) {
            inputSet.add(c);
        }

        return inputSet.size() == input.length();
    }
}
