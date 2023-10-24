package baseball;

import java.util.Arrays;

public enum GameStatus {
    IN_PROGRESS(1),
    ENDED(2);

    private int option;

    GameStatus(int option) {
        this.option = option;
    }

    public static GameStatus of(int option) {
        return Arrays.stream(GameStatus.values())
                .filter(s -> s.option == option)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 1(재시작) 또는 2(종료)만 입력 가능합니다."));
    }

}
