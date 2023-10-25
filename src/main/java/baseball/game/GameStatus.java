package baseball.game;

public enum GameStatus {
    PLAY("1"),
    FINISH("2"),
    ;

    private final String value;

    GameStatus(String value) {
        this.value = value;
    }

    public boolean isPlay() {
        return this == PLAY;
    }
}
