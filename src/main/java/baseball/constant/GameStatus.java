package baseball.constant;

import java.util.Arrays;

public enum GameStatus {
    RESTART(1),
    QUIT(2);

    private int decisionNumber;

    GameStatus(int decisionNumber) {
        this.decisionNumber = decisionNumber;
    }

    public static GameStatus apply(Integer number) {
        return Arrays.stream(GameStatus.values())
                .filter(status -> status.decisionNumber == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("숫자 1 혹은 2를 입력해야 합니다."));
    }


}
