package baseball.validation;

import java.util.HashSet;
import java.util.Set;
public class NumberValidator {
    public String isValidNumber(String input) {
        Set<Character> numberSet = new HashSet<>();
        for (char digit : input.toCharArray()) {
            numberSet.add(digit);
        }
        if (input.length() != 3 || !input.matches("[1-9]+") ||  numberSet.size() != 3 )  {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
        return input;
    }
}
