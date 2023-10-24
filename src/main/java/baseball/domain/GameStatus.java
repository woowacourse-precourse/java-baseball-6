package baseball.domain;

public enum GameStatus {
    WIN, PLAYING;

    public boolean isPlaying() {
        return this == PLAYING;
    }
}
