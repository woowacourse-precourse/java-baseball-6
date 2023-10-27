package baseball;
public class InputValidator {
    public static void isRestartInputValid(int userInput) {
        if (userInput == 1 || userInput == 2) {
            return;
        } else {
            throw new IllegalArgumentException(Message.getErrorMessage());
        }
    }

    public static void isUserInputValid(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException(Message.getErrorMessage());
        }
        for (int i = 0; i < 3; i++) {
            if (userInput.charAt(i) - '0' < 1 || userInput.charAt(i) - '0' > 9) {
                throw new IllegalArgumentException(Message.getErrorMessage());
            }
        }
    }
}