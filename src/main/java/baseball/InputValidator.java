package baseball;

public class InputValidator {
    public static void checkUserTrialInput(String userInput) {
        checkInputLength(userInput, 3);
        checkInputNumberRange(userInput, 1, 9);
        checkDuplicateNumber(userInput);
    }

    public static void checkUserRestartInput(String userInput) {
        checkInputLength(userInput, 1);
        checkInputNumberRange(userInput, 1, 2);
    }

    private static void checkInputLength(String userInput, int length) {
        if (userInput.length() != length) {
            throw new IllegalArgumentException(length + "자리의 숫자를 입력하세요.");
        }
    }

    private static void checkInputNumberRange(String userInput, int start, int end) {
        for (char c : userInput.toCharArray()) {
            if (c < intToChar(start) || c > intToChar(end)) {
                throw new IllegalArgumentException("올바른 숫자를 입력하세요.");
            }
        }
    }

    private static void checkDuplicateNumber(String userInput) {
        for (int i = 0; i < userInput.length() - 1; i++) {
            for (int j = i + 1; j < userInput.length(); j++) {
                if (userInput.charAt(i) == userInput.charAt(j)) {
                    throw new IllegalArgumentException("중복되지 않은 숫자를 입력하세요.");
                }
            }
        }
    }

    private static char intToChar(int num) {
        return String.valueOf(num).charAt(0);
    }
}
