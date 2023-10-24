package baseball.controller;

public enum GameConstants {

    MIN_NUMBER(1),
    MAX_NUMBER(9),
    NUMBER_SIZE(3);

    private final int number;

    GameConstants(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
