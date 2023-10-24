package baseball;

public enum GameStatus {
    PLAY, END;

    boolean isPlay() {
        return this == PLAY;
    }
}
