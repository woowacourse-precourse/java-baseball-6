package baseball.exception.computer;

public class ComputerEndStateRefreshException extends RuntimeException {
    private static final String REFRESH_END_STATE_ERROR_MESSAGE = "종료된 게임은 리프레시할 수 없습니다.";

    public ComputerEndStateRefreshException() {
        super(REFRESH_END_STATE_ERROR_MESSAGE);
    }
}
