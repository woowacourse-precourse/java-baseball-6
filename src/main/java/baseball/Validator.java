package baseball;

import java.util.Arrays;
import java.util.Objects;

public class Validator {
    private static final int BALL_LENGTH = 3;

    public static void validateUserInputBall(String userInput) throws IllegalArgumentException {
        if (Objects.isNull(userInput)) {
            throw new IllegalArgumentException("입력은 null이 될 수 없습니다.");
        }
        if (!isStringLength(userInput, BALL_LENGTH)) {
            throw new IllegalArgumentException("Ball은 " + BALL_LENGTH + "글자를 만족해야 합니다.");
        }
        if (!isNumber(userInput)) {
            throw new IllegalArgumentException("Ball은 숫자만 가능합니다");
        }
        if (hasDuplicateNumbers(userInput)) {
            throw new IllegalArgumentException("Ball에 중복된 숫자가 존재합니다.");
        }
    }

    public static void validateRestartInput(String userInput) throws IllegalArgumentException {
        if (!isNumber(userInput)) {
            throw new IllegalArgumentException("재시작 선택은 숫자만 가능합니다");
        }
        int intUserInput = Integer.parseInt(userInput);
        if (!RestartType.containsValue(intUserInput)) {
            throw new IllegalArgumentException("재시작 선택 잘못된 값입니다.");
        }
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
