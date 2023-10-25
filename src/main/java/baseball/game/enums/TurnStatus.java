package baseball.game.enums;

public enum TurnStatus {

    PLAYING,
    TURNOVER,
    ;

    public boolean isPlaying() {
        return this == PLAYING;
    }

}
