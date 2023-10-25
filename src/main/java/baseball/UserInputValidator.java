package baseball;

public class UserInputValidator {
    private static final int NUMBER_LENGTH = 3;

    public static boolean checkValidBaseballNumber(String userInput) {
        if (userInput.length() != NUMBER_LENGTH) {
            return false;
        }

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            char userInputChar = userInput.charAt(i);

            if (userInputChar < '1' || userInputChar > '9') {
                return false;
            }

            if (userInput.indexOf(userInputChar) != userInput.lastIndexOf(userInputChar)) {
                return false;
            }
        }

        return true;
    }


    public static boolean checkValidRestartValue(String userInput) {
        if (userInput.length() != 1) {
            return false;
        }
        char inputChar = userInput.charAt(0);
        return inputChar == '1' || inputChar == '2';
    }
}
