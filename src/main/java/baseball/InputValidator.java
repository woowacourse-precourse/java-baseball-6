package baseball;
public class InputValidator {
    public static boolean isRestartInputValid(int userInput) {
        if (userInput == 1 || userInput == 2) {
            return true;
        } else {
            throw new IllegalArgumentException(Message.getErrorMessage());
        }
    }

    public static boolean isUserInputValid(int[] userNumbers) {
        if (userNumbers.length != 3) {
            throw new IllegalArgumentException(Message.getErrorMessage());
        }
        for (int i = 0; i < 3; i++) {
            if (userNumbers[i] < 1 || userNumbers[i] > 9) {
                throw new IllegalArgumentException(Message.getErrorMessage());
            }
        }
        return true;
    }
}