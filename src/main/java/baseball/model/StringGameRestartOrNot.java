package baseball.model;

public class StringGameRestartOrNot {
    private static final String GAME_RESTART = "1";
    private static final String GAME_OVER = "2";
    private final String stringGameRestartOrNot;

    public StringGameRestartOrNot(String stringGameRestartOrNot) {

        this.stringGameRestartOrNot = stringGameRestartOrNot;
    }

    private void validateStringGameRestartOrNot(String stringGameRestartOrNot) {
        if (!GAME_RESTART.equals(stringGameRestartOrNot) && !GAME_OVER.equals(stringGameRestartOrNot)) {
            throw new IllegalArgumentException("[ERROR] 1 또는 2의 값이 아닙니다.");
        }
    }

    public boolean doesRestart() {
        return GAME_RESTART.equals(stringGameRestartOrNot);
    }
}
