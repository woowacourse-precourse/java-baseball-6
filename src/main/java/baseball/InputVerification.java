package baseball;

public class InputVerification {
    public static void verifyUserInput(String userInput) {
        boolean inputCheck = true;
        if (userInput.length() != Constants.ANSWER_LENGTH) {
            throw new IllegalArgumentException("1-9 사이의 3자리 수를 입력하세요.");
        }
        for (int i = 0; i < userInput.length(); i++) {
            if (!isNumber(userInput.charAt(i))) {
                inputCheck = false;
            }
            for (int j = i + 1; j < userInput.length(); j++) {
                if (userInput.charAt(i) == userInput.charAt(j)) {
                    inputCheck = false;
                    break;
                }
            }
            if (!inputCheck) {
                throw new IllegalArgumentException("1-9 사이의 3자리 수를 중복되는 수 없이 입력하세요.");
            }
        }
    }

    private static Boolean isNumber(char num) {
        return (Character.isDigit(num)) && (num != '0');
    }

    public static void verifyEndInput(String gameEndInput) {
        if (gameEndInput.length() != 1) {
            throw new IllegalArgumentException("1 혹은 2를 입력하세요.");
        }
        if (gameEndInput.charAt(0) != '1' && gameEndInput.charAt(0) != '2') {
            throw new IllegalArgumentException("1 혹은 2를 입력하세요.");
        }
    }
}
