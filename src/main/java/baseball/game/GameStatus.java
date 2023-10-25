package baseball.game;

import static baseball.constant.MessageConstants.NOT_RESTART_OR_EXIT;
import static baseball.constant.NumberConstants.EXIT_NUMBER_STRING;
import static baseball.constant.NumberConstants.RESTART_NUMBER_STRING;

import java.util.Objects;

public enum GameStatus {
    RESTART, EXIT;

    public static GameStatus chooseStatus(String numberString) {
        if (Objects.equals(numberString, RESTART_NUMBER_STRING)) {
            return RESTART;
        }

        if (Objects.equals(numberString, EXIT_NUMBER_STRING)) {
            return EXIT;
        }

        throw new IllegalArgumentException(numberString + NOT_RESTART_OR_EXIT);
    }

}
