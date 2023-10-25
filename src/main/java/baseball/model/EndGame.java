package baseball.model;

public class EndGame {
    public static final String RESTART = "1";
    public static final String END = "2";
    private final String userChoice;

    public EndGame(String userChoice) {
        validateUserChoice(userChoice);
        this.userChoice = userChoice;
    }

    public boolean isRestart() {
        return userChoice.equals(RESTART);
    }

    private void validateUserChoice(String choice) {
        if (!choice.equals(RESTART) && !choice.equals(END)) {
            throw new IllegalArgumentException();
        }
    }
}