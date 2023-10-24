package baseball.exception.game;

public class GameResultTotalCountException extends IllegalArgumentException {
    private final static String GAME_RESULT_STRIKE_BALL_TOTAL_COUNT_ERROR_MESSAGE = "Strike와 Ball의 갯수는 3개를 넘을 수 없습니다.";

    public GameResultTotalCountException() {
        super(GAME_RESULT_STRIKE_BALL_TOTAL_COUNT_ERROR_MESSAGE);
    }
}
