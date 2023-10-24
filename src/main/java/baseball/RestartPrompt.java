package baseball;

public class RestartPrompt {
    private static final String STOP = "2";

    public static boolean stringToBoolean(String userInput) {
        restartUserInputException(userInput);
        if (userInput.equals(STOP)) {
            return false;
        }
        return true;
    }

    private static void restartUserInputException(String userInput) {
        if (!userInput.equals("1") && !userInput.equals("2")) {
            throw new IllegalArgumentException();
        }
    }
}
