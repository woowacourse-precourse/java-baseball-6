package baseball.util;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public static void validateThreeDigitsInput(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 공백 문자만 포함하고 있습니다.");
        } else if (input.length() != 3) {
            throw new IllegalArgumentException("입력값은 3개의 숫자여야 합니다.");
        } else if (!isNumber(input)) {
            throw new IllegalArgumentException("입력값중 1~9 숫자가 아닌 값이 존재 합니다.");
        } else if (!hasUniqueNumbers(input)) {
            throw new IllegalArgumentException("입력값은 서로 다른 3개의 숫자여야 합니다.");
        }
    }

    public static void validateGameModeInput(String input) {
        if(!input.equals("1") && !input.equals("2")){
            throw new IllegalArgumentException("게임 모드는 1또는 2만 입력해야 합니다.");
        }
    }

    private static boolean isNumber(String input) {
        return input.matches("[1-9]+");
    }

    private static boolean hasUniqueNumbers(String input) {
        Set<Character> uniqueNumbers = new HashSet<>();
        for (char digit : input.toCharArray()) {
            uniqueNumbers.add(digit);
        }
        return uniqueNumbers.size() == 3;
    }
}
