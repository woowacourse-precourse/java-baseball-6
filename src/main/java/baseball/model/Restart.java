package baseball.model;

import baseball.validator.Validator;

public class Restart {
    private int restart;
    private final int RESTART = 1;

    public Restart(int restart) {
        Validator.validateInRange(restart, 1, 2);
        this.restart = restart;
    }

    public boolean whetherRestart() {
        return restart == RESTART;
    }
}
