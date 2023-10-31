package baseball;

public class RestartPrompt {
    private static final String RESTART = "1";
    private static final String STOP = "2";

    public static boolean stringToBoolean(String userInput) {
        restartUserInputException(userInput);
        return !userInput.equals(STOP);
    }

    private static void restartUserInputException(String userInput) {
        if (!RESTART.equals(userInput) && !STOP.equals(userInput)) {
            throw new IllegalArgumentException();
        }
    }
}
