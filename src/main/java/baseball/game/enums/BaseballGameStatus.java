package baseball.game.enums;

public enum BaseballGameStatus {

    RUNNING,
    STOP,
    ;

    public boolean isRunning() {
        return this == RUNNING;
    }

}
