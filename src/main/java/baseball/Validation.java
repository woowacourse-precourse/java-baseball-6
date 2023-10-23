package baseball;

import java.util.ArrayList;
import java.util.List;

public class Validation {

    public boolean isNotNull(String num) {
        boolean flag = true;

        if (num == null || num.isBlank()) {
            flag = false;
        }

        return flag;
    }

    public boolean isDigitInput(String num) {
        boolean flag = true;

        for (int i = 0; i < num.length(); i++) {
            if (!Character.isDigit(num.charAt(i))) {
                flag = false;
                break;
            }
        }

        return flag;
    }

    public boolean isThreeLength(String num) {
        boolean flag = true;

        if (num.length() != 3) {
            flag = false;
        }

        return flag;
    }

    public boolean isOneLength(String num) {
        boolean flag = true;

        if (num.length() != 1) {
            flag = false;
        }

        return flag;
    }

    public boolean isEachUnique(String num) {
        boolean flag = true;
        List<Character> nums = new ArrayList<>();

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);

            if (nums.contains(c)) {
                flag = false;
                break;
            }
            nums.add(c);
        }

        return flag;
    }

    public boolean isOneOrTwo(String num) {
        boolean flag = true;

        if (!(num.equals("1") || num.equals("2"))) {
            flag = false;
        }

        return flag;
    }
}
