package baseball.model;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class NumberRule {
    private static final int DIGITS = 3;
    public boolean isThreeDigits(String input) {
        if(input.length() != DIGITS) {
            return false;
        }
        return true;
    }

    public boolean isNumber(String str) {
        String pattern = "^[0-9]*$";
        return Pattern.matches(pattern, str);
    }

    public boolean isNotDuplicate(String str) {
        Set<Character> set = new HashSet<>();
        for(char num : str.toCharArray()) {
            set.add(num);
        }
        return set.size() == str.length();
    }
}
