package baseball.constant;

import java.util.Arrays;

public enum GameStatus {
    RESTART(1),
    QUIT(2);

    private final int decisionNumber;

    GameStatus(int decisionNumber) {
        this.decisionNumber = decisionNumber;
    }

    public static GameStatus apply(Integer number) {
        return Arrays.stream(GameStatus.values())
                .filter(status -> status.decisionNumber == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.DECISION_NUMBER));
    }


}
