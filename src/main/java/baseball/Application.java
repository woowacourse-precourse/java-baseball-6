package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();
        Output output = new Output();
        GameState gameState = new GameState(output.gameStart());
        NumberController numberController = new NumberController();
        while (gameState.getState() != GameState.END_STATE) {
            List<Integer> computer = new ArrayList<>(numberController.randomComputerNumberGenerator());
            while (gameState.getState() != GameState.GAME_SUCCEED_STATE) {
                GameScore gameScore = new GameScore(numberController.suggestedNumberConverter(input.numberSuggestion()),
                        computer);
                output.drawOutResult(gameScore.getBall(), gameScore.getStrike());
                gameState.checkGameSucceeded(gameScore.getStrike());
            }
            output.gameSucceeded();
            gameState.checkGameRetryOrEnd(input.retryOrEnd());
        }
    }
}
