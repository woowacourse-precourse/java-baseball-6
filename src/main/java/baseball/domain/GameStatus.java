package baseball.domain;

import java.util.Arrays;

public enum GameStatus {
    PLAY("1", true),
    QUIT("2", false);

    private final String gameCommand;
    private final boolean gameContinue;

    GameStatus(String gameCommand, boolean gameContinue) {
        this.gameCommand = gameCommand;
        this.gameContinue = gameContinue;
    }

    public String getGameCommand() {
        return gameCommand;
    }

    public boolean isGameContinue() {
        return gameContinue;
    }

    public static GameStatus from(String gameCommand) {
        return Arrays.stream(GameStatus.values())
                .filter(gameStatus -> gameStatus.getGameCommand().equals(gameCommand))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("1 또는 2를 입력해야 합니다."));
    }
}
