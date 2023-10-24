package baseball.exception.computer;

public class GameStateNotFoundException extends IllegalArgumentException {
    private static final String GAME_STATE_NOT_FOUND_BY_COMMAND_ERROR_MESSAGE = "존재하지 않는 게임 상태 입니다.";

    public GameStateNotFoundException() {
        super(GAME_STATE_NOT_FOUND_BY_COMMAND_ERROR_MESSAGE);
    }
}
