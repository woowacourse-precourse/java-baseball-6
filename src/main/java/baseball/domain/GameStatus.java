package baseball.domain;

import static baseball.util.ExceptionMessage.INVALID_GAME_COMMAND;

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
                .orElseThrow(() -> new IllegalArgumentException(INVALID_GAME_COMMAND.getMessage()));
    }

}
