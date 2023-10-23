package baseball.model;

import baseball.validator.Validator;

public class Restart {
    private final int number;

    public Restart(int number) {
        Validator.validateInRange(number, 1, 2);
        this.number = number;
    }

    public Restart(String restart) {
        this(Integer.parseInt(restart));
    }

    public static boolean isRestart(Restart restart) {
        return restart.number == 1;
    }

    public static boolean isEnd(Restart restart) {
        return restart.number == 2;
    }
}
