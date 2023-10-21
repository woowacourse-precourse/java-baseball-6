package baseball.util;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Validation {
    public static String isValidInput(String input) {
        isEmpty(input);
        isLengthThree(input);
        isInRange(input);
        isDuplicate(input);
        return input;
    }

    public static void isEmpty(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("값을 입력해 주세요.");
        }
    }

    public static void isLengthThree(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("세 자리 숫자를 입력해 주세요.");
        }
    }

    public static void isInRange(String input) {
        if (!Pattern.matches("^[1-9]+$", input)) {
            throw new IllegalArgumentException("1부터 9까지의 숫자만 입력 가능 합니다.");
        }
    }

    public static void isRestartInputInRange(String input) {
        if (!Pattern.matches("^[12]$", input)) {
            throw new IllegalArgumentException("1 혹은 2의 숫자만 입력 가능 합니다.");
        }
    }

    public static void isDuplicate(String input) {
        Set<Character> number = new HashSet<>();
        for (char digit : input.toCharArray()) {
            number.add(digit);
        }
        if (number.size() != 3) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력해 주세요.");
        }
    }
}
