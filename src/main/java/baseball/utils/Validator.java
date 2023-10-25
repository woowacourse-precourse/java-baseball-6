package baseball.utils;

import baseball.enums.MessageType;
import java.util.HashSet;
import java.util.Set;

public class Validator {
    public static final int NUMBER_LENGTH = 3;

    public static void validateNumberInput(String input) {
        validateIsNumber(input);
        validateLength(input);
        validateRange(input);
        validateNoDuplication(input);
    }

    public static void validateEndInput(String input) {
        validateIsNumber(input);
        if (!(input.equals(MessageType.RESTART.getMessage()) || input.equals(MessageType.FINISH.getMessage()))) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다. 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }

    private static void validateIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다. 정수를 입력해주세요.");
        }
    }

    private static void validateLength(String input) {
        if (input.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("잘못된 길이의 값을 입력했습니다. 3자리 정수를 입력해주세요.");
        }
    }

    private static void validateRange(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다. 0을 포함하지 않는 3자리 정수를 입력해주세요.");
        }
    }

    private static void validateNoDuplication(String input) {
        Set<Character> inputs = new HashSet<>();

        for (char a : input.toCharArray()) {
            inputs.add(a);
        }

        if (inputs.size() != input.length()) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다. 중복 되지 않는 정수를 입력해주세요.");
        }
    }
}
