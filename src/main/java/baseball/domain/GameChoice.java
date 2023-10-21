package baseball.domain;

import static baseball.handler.ErrorHandler.INVALID_NUMBER;

public class GameChoice {

    private final int choice;
    private final int RESTART_GAME = 1;
    private final int FINISH_GAME = 2;

    public GameChoice() {
        this.choice = RESTART_GAME;
    }

    public GameChoice(int choice) {
        validate(choice);

        this.choice = choice;
    }

    private void validate(int choice) {
        if (choice != RESTART_GAME && choice != FINISH_GAME) {
            throw INVALID_NUMBER.getException();
        }
    }

    public boolean isRestart() {
        return choice == RESTART_GAME;
    }
}
