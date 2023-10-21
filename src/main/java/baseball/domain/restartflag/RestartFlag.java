package baseball.domain.restartflag;

public class RestartFlag {

    private static final int RESTART_GAME_FLAG = 1;
    private static final int END_GAME_FLAG = 2;
    private static final String ERROR_MESSAGE_WRONG_INPUT = "1 혹은 2만 입력해 주세요.";

    private final int flag;

    public RestartFlag(int flag) {
        validateInput(flag);
        this.flag = flag;
    }

    public boolean isRestart() {
        return flag == RESTART_GAME_FLAG;
    }

    private void validateInput(int flag) {
        if (!isRightValue(flag)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_WRONG_INPUT);
        }
    }

    private boolean isRightValue(int flag) {
        return flag == RESTART_GAME_FLAG || flag == END_GAME_FLAG;
    }
}
