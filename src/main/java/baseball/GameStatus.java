package baseball;

public class GameStatus {

    public static final int GAME_INIT = 0;
    public static final int GAME_RESTART = 1;
    public static final int GAME_END = 2;
    private int gameStatus;

    public GameStatus() {
        this.gameStatus = GAME_INIT;
    }

    public boolean isEnd() {
        return this.gameStatus == GAME_END;
    }

    public void updateGameStatus(String input) {
        validateInput(input);
        this.gameStatus = Integer.parseInt(input);
    }

    private void validateInput(String input) {
        if (!input.matches("[1-2]")) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }
}