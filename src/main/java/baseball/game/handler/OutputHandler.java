package baseball.game.handler;

import baseball.game.calculator.ResultCalculator;
import baseball.constants.GameConstants;

public class OutputHandler {

    private final ResultCalculator resultCalculator = new ResultCalculator();

    public void printGameStartMessage() {
        System.out.println(GameConstants.GAME_START_MESSAGE);
    }

    public void printInputRequestMessage() {
        System.out.println(GameConstants.INPUT_REQUEST_MESSAGE);
    }

    public boolean printResultMessage(String userInput, String computerNumber) {
        String result = resultCalculator.calculateResult(userInput, computerNumber);
        System.out.println(result);

        return result.contains(GameConstants.VICTORY_MESSAGE);
    }

    public void printAskGameRestartMessage() {
        System.out.println(GameConstants.ASK_GAME_RESTART_MESSAGE);
    }
}
