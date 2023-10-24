package baseball;

import static baseball.constants.Game.QUIT;
import static baseball.constants.Game.START;

import camp.nextstep.edu.missionutils.Console;

public class GameStatus {
    private final String gameStatus;

    public GameStatus() {
        String gameStatusInput = Console.readLine();
        validateGameStatusInput(gameStatusInput);

        gameStatus = gameStatusInput;
    }

    public String getGameStatus() {
        return gameStatus;
    }

    private void validateGameStatusInput(String gameStatusInput) {
        if (!gameStatusInput.equals(START) && !gameStatusInput.equals(QUIT)) {
            throw new IllegalArgumentException();
        }
    }
}
