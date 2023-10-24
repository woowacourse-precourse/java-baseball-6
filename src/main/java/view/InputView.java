package view;

import camp.nextstep.edu.missionutils.Console;
import constant.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final int NUMBER_COUNT = 3;
    private static final int RESTART_ANSWER = 1;
    private static final int SHUTDOWN_ANSWER = 2;

    public static List<Integer> inputNumbers() {
        List<Integer> convertedNumber = new ArrayList<>();
        String input = Console.readLine();
        validateLength(input);
        for (int i = 0; i < input.length(); i++) {
            int digit = getDigit(input, i);
            validateDigit(convertedNumber, digit);
            convertedNumber.add(digit);
        }
        return convertedNumber;
    }

    private static void validateLength(String input) {
        if (input.length() != NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
    }

    private static int getDigit(String input, int i) {
        return input.charAt(i) - '0';
    }

    private static void validateDigit(List<Integer> convertedNumber, int digit) {
        if (convertedNumber.contains(digit)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBER_INPUT.getMessage());
        }
    }

    public static boolean restartGame() {
        int input;
        try {
            input = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
        return restartWhether(input);
    }

    private static boolean restartWhether(int input) {
        return switch (input) {
            case RESTART_ANSWER -> true;
            case SHUTDOWN_ANSWER -> false;
            default -> throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.getMessage());
        };
    }
}
