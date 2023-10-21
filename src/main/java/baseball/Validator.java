package baseball;

import java.util.Arrays;

public class Validator {
    public static void validateUserBall(String userBall) throws IllegalArgumentException {
        if (!isStringLength(userBall, 3))
            throw new IllegalArgumentException("사용자 입력은 3글자를 만족해야 합니다.");
        if (!isNumber(userBall))
            throw new IllegalArgumentException("사용자 입력은 숫자만 가능합니다");
        if (hasDuplicateNumbers(userBall))
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
    }

    private static boolean isStringLength(String input, int length) {
        if (input.length() == length)
            return true;
        return false;
    }

    private static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean hasDuplicateNumbers(String input) {
        boolean[] numbers = new boolean[10];
        Arrays.fill(numbers, false);

        for (int i = 0; i < input.length(); i++) {
            int num = charNumToInt(input.charAt(i));
            if (numbers[num])
                return true;
            numbers[num] = true;
        }
        return false;
    }

    private static int charNumToInt(char num) {
        return num - '0';
    }

}
