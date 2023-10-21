package baseball.domain;

import static baseball.handler.ErrorHandler.INVALID_NUMBER;

public class GameChoice {

    private final int choice;

    public GameChoice() {
        this.choice = 1;
    }

    public GameChoice(int choice) {
        validate(choice);

        this.choice = choice;
    }

    private void validate(int choice) {
        if (choice != 1 && choice != 2) {
            throw INVALID_NUMBER.getException();
        }
    }

    public boolean isRestart() {
        return choice == 1;
    }
}
