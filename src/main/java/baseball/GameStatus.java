package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameStatus {
    private final String gameStatus;

    private static final String START = Constants.START;
    private static final String QUIT = Constants.QUIT;

    public GameStatus() {
        String gameStatusInput = Console.readLine();
        validateGameStatusInput(gameStatusInput);

        this.gameStatus = gameStatusInput;
    }

    public String getGameStatus() {
        return this.gameStatus;
    }

    private void validateGameStatusInput(String gameStatusInput) {
        if (!gameStatusInput.equals(START) && !gameStatusInput.equals(QUIT)) {
            throw new IllegalArgumentException();
        }
    }
}
