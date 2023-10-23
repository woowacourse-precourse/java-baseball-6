package baseball.constant;

import java.util.Arrays;

public enum GameStatus {
    RESTART(1),
    EXIT(2);

    private int signatureNumber;

    GameStatus(int signatureNumber) {
        this.signatureNumber = signatureNumber;
    }

    public static GameStatus find(Integer number) {
        return Arrays.stream(GameStatus.values())
                .filter(status -> status.signatureNumber == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("숫자 1 혹은 2를 입력해야 합니다."));
    }


}
