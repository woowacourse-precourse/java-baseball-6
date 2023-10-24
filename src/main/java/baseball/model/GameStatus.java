package baseball.model;

import baseball.validator.Validator;

public class GameStatus {
    private final int number;

    public GameStatus(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        Validator.validateInRange(number, 1, 2);
    }

    public static GameStatus stringToGameStatus(String status) {
        return new GameStatus(Integer.parseInt(status));
    }

    public static boolean isRestart(GameStatus status) {
        return status.number == 1;
    }

    public static boolean isEnd(GameStatus status) {
        return status.number == 2;
    }

}
