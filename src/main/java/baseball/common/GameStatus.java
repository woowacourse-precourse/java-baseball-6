package baseball.common;

import static baseball.common.exception.ExceptionMessage.ILLEGAL_INPUT_FOR_STATUS;

public enum GameStatus {
    ONPLAYING("1", true), END("2", false), ALL_CORRECT("0", false);

    private String number;
    private boolean start;

    GameStatus(String number, boolean start) {
        this.number = number;
        this.start = start;
    }

    public boolean isEnd() {
        return this == END;
    }

    public boolean isAllCorrect() {
        return this == ALL_CORRECT;
    }

    public static GameStatus statusMatch(String number) {
        for (GameStatus status : GameStatus.values()) {
            if (status.number.equals(number)) {
                return status;
            }
        }

        throw new IllegalArgumentException(ILLEGAL_INPUT_FOR_STATUS.message());
    }
}
