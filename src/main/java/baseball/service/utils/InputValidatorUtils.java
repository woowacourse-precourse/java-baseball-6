package baseball.service.utils;

import java.util.HashSet;
import java.util.Set;

public class InputValidatorUtils {

    public boolean isValidInput(String input) {
        if (input.length() == 3 && isNum(input) && !isDuplicated(input)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isNum(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) || c == '0') {
                return false;
            }
        }
        return true;
    }

    public boolean isDuplicated(String input) {
        String[] nums = input.split("");
        Set<String> set = new HashSet<>();

        for (String num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
