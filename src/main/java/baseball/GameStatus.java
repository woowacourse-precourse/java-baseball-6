package baseball;

import static baseball.constant.NumberConstants.RESTART_NUMBER_STRING;

import java.util.Objects;

public enum GameStatus {
    RESTART, EXIT;

    public static GameStatus chooseStatus(String numberString) {
        if (Objects.equals(numberString, RESTART_NUMBER_STRING)) {
            return RESTART;
        }

        return EXIT;
    }

}
