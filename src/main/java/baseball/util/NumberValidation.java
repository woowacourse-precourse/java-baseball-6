package baseball.util;

import java.util.Arrays;

public class NumberValidation {

    public static void InputValidate(String UserNumber) {
        NumberValidate(UserNumber);
        SizeValidate(UserNumber);
        ZeroValidate(UserNumber);
        DupValidate(UserNumber);
    }

    public static void NumberValidate(String UserNumber) {
        try {
            Integer.parseInt(UserNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 문자를 입력했습니다.");
        }
    }

    public static void SizeValidate(String UserNumber) {
        if (UserNumber.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
        }
    }

    public static void ZeroValidate(String UserNumber) {
        String[] num = UserNumber.split("");
        for (String i : num) {
            if (i.equals("0")) {
                throw new IllegalArgumentException("각 자리별로 1부터 9까지의 숫자만 입력 가능합니다.");
            }
        }
    }

    public static void DupValidate(String UserNumber) {
        String[] num = UserNumber.split("");
        if (num.length != Arrays.stream(num).distinct().count()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }
}
