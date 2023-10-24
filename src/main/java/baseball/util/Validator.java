package baseball.util;

import java.util.HashSet;
import java.util.Set;
import baseball.constant.Constant;

public class Validator {
    public Boolean gameInputVaildate(String input) {
        return validLength(input) && validInput(input) && validDuplication(input);
    }

    // 길이 조건 3자리
    public Boolean validLength(String input) {
        return input.length() == Constant.MAX_DIGIT;
    }

    // 중복 검사
    public Boolean validDuplication(String input) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            char digit = input.charAt(i);
            set.add(digit);
        }
        return set.size() == Constant.MAX_DIGIT;
    }

    // 1~9 사이 수인지
    public Boolean validInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            int digit = input.charAt(i) - '0';
            // 1~9 사이 수가 아니라면
            if (digit < Constant.MIN_NUMBER || digit > Constant.MAX_NUMBER)
                return false;
        }
        return true;
    }

    public Boolean quitInputValidate(String input) {
        if (Constant.CONTINUE_INPUT.equals(input) || Constant.QUIT_INPUT.equals(input))
            return true;
        return false;
    }
}
