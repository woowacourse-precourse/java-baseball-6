package baseball.domain.model;

import java.util.Arrays;

public enum GameStatus {
    GAME_OVER("3스트라이크"),
    CONTINUE(""),
    EXIT("");


    private final String resultMessage;

    GameStatus(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public static GameStatus of(String result) {
        return Arrays.stream(values())
                        .filter(gameStatus -> gameStatus.resultMessage.equals(result))
                        .findFirst()
                        .orElse(CONTINUE);
    }
}

