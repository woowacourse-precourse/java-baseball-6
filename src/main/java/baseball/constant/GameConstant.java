package baseball.constant;

public enum GameConstant {
    RESTART_GAME("1"), EXIT("2");

    public final String number;
    GameConstant(String number) {
        this.number = number;
    }
}
