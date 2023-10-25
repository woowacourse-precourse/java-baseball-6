package baseball.validator;

import baseball.view.UIMessage;

public class InputValidator {
    public static void validatePlayNumber(String input) {
        if (!isInteger(input) || !isThreeDigit(input) || hasDuplicatedNumber(input)) {
            throw new IllegalArgumentException(UIMessage.END_MESSAGE.getMessage());
        }
    }

    public static void validateGameContinue(String input) {
        if (!isInteger(input) || !isOneOrTwo(input)) {
            throw new IllegalArgumentException(UIMessage.END_MESSAGE.getMessage());
        }
    }

    private static boolean isInteger(String input) {
        try {
            int number = Integer.parseInt(input);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(UIMessage.END_MESSAGE.getMessage());
        }
        return false;
    }

    private static boolean isThreeDigit(String input) {
        int number = Integer.parseInt(input);
        return number >= 100 && number <= 999;
    }

    private static boolean isOneOrTwo(String input) {
        int number = Integer.parseInt(input);
        return number == 1 || number == 2;
    }

    private static boolean hasDuplicatedNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }
}
