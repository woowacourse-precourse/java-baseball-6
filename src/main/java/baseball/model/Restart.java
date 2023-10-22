package baseball.model;

public class Restart {

    private final int decision;
    private static final int RESTART = 1;
    private static final int EXIT = 2;

    public Restart(int decision) {
        this.decision = decision;
    }

    public static Restart restartFactory(String userInput) {

        UserInput.checkIsNumber(userInput);
        int decision = Integer.parseInt(userInput);
        restartValidation(decision);
        return new Restart(decision);
    }

    public static void restartValidation(int decision) {
        if (decision == RESTART || decision == EXIT) {
            throw new IllegalArgumentException();
        }
    }

    public int getDecision() {
        return this.decision;
    }
}
