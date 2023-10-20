package baseball.dto;

public enum RetryDto {

    RESTART,
    EXIT;

    public boolean isRestart() {
        return this == RESTART;
    }
}
