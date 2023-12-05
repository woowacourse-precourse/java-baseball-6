package baseball.domain;

public enum GameStatus {
    PLAYING, WIN, END;

    public boolean isPlaying() {
        return this == PLAYING;
    }

    public boolean isEnd() {
        return this == END;
    }

    public boolean isWin() {
        return this == WIN;
    }
}
