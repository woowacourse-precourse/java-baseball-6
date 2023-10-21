package baseball.domain.game;

public enum GameState {
    PLAYING, END;

    public GameState end() {
        return END;
    }

    public boolean isEnd() {
        return this == END;
    }

    public boolean isPlaying() {
        return this == PLAYING;
    }
}
