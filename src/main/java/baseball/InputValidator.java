package baseball;

public class InputValidator {
    public static void checkUserTrialInput(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("3자리의 숫자를 입력하세요.");
        }

        for (char c : userInput.toCharArray()) {
            if (c < '1' || c > '9') {
                throw new IllegalArgumentException("올바른 숫자를 입력하세요.");
            }
        }

        for (int i = 0; i < userInput.length() - 1; i++) {
            for (int j = i + 1; j < userInput.length(); j++) {
                if (userInput.charAt(i) == userInput.charAt(j)) {
                    throw new IllegalArgumentException("중복되지 않은 숫자를 입력하세요.");
                }
            }
        }
    }

    public static void checkUserRestartInput(String userInput) {
        if (userInput.length() != 1) {
            throw new IllegalArgumentException("1자리의 숫자를 입력하세요.");
        }

        for (char c : userInput.toCharArray()) {
            if (c < '1' || c > '2') {
                throw new IllegalArgumentException("올바른 숫자를 입력하세요.");
            }
        }
    }
}
