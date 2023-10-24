package baseball.game;

public enum GameStatus {
    PLAYING(1),
    EXIT(2);

    private final int num;

    GameStatus(int num) {
        this.num = num;
    }

    public boolean isPlaying() {
        return this == PLAYING;
    }
}
