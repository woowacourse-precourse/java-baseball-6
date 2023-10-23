package baseball.model;

import baseball.validator.Validator;

public class GameStatus {
    private final int number;

    public GameStatus(int number) {
        Validator.validateInRange(number, 1, 2);
        this.number = number;
    }

    public GameStatus(String status) {
        this(Integer.parseInt(status));
    }

    public static boolean isRestart(GameStatus status) {
        return status.number == 1;
    }

    public static boolean isEnd(GameStatus status) {
        return status.number == 2;
    }
}
