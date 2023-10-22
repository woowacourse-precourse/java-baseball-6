package baseball.model;

public class GameRestartOrNot {
    private static final String GAME_RESTART = "1";
    private static final String GAME_OVER = "2";
    private final String gameRestartOrNot;

    public GameRestartOrNot(String gameRestartOrNot) {
        validateStringGameRestartOrNot(gameRestartOrNot);
        this.gameRestartOrNot = gameRestartOrNot;
    }

    private void validateStringGameRestartOrNot(String gameRestartOrNot) {
        if (!GAME_RESTART.equals(gameRestartOrNot) && !GAME_OVER.equals(gameRestartOrNot)) {
            throw new IllegalArgumentException("[ERROR] 1 또는 2의 값이 아닙니다.");
        }
    }

    public boolean doesRestart() {
        return GAME_RESTART.equals(gameRestartOrNot);
    }
}
