package baseball;

import java.util.ArrayList;
import java.util.List;

public class Validation {

    public boolean runException(String num, String option) {
        boolean flag = true;
            if (!isValidate(num, option)) {
                flag = false;
                throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 게임을 종료합니다.");
            }
        return flag;
    }

    public boolean isValidate(String num, String option) {
        boolean flag = true;
        // 게임 진행중 입력
        if (option.equals("gaming")) {
            if (!isNotNull(num) || !isDigitInput(num) || !isThreeLength(num) || !isEachUnique(num)) {
                flag = false;
            }
        }
        // 게임 종료 후 입력
        else if (option.equals("game over")) {
            if (!isNotNull(num) || !isDigitInput(num) || !isOneLength(num) || !isOneOrTwo(num)) {
                flag = false;
            }
        }
        return flag;
    }

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
