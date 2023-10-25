package baseball.core;

import static baseball.constants.ExceptionMessage.GAME_STATUS_EXCEPTION;
import static baseball.constants.Game.QUIT;
import static baseball.constants.Game.START;

import camp.nextstep.edu.missionutils.Console;

public class GameStatus {
    private final String gameStatus;

    public GameStatus() {
        String input = generatePrompt();
        validateGameStatusInput(input);

        gameStatus = input;
    }

    public String getGameStatus() {
        return gameStatus;
    }

    private String generatePrompt() {
        return Console.readLine();
    }

    private void validateGameStatusInput(String gameStatusInput) {
        if (!gameStatusInput.equals(START) && !gameStatusInput.equals(QUIT)) {
            throw new IllegalArgumentException(GAME_STATUS_EXCEPTION);
        }
    }
}
