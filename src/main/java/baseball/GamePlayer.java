package baseball;

import java.util.List;

public class GamePlayer {
    private final GameState gameState;
    private final GameNumberController gameNumberController;

    public GamePlayer(GameState gameState, GameNumberController gameNumberController) {
        this.gameState = gameState;
        this.gameNumberController = gameNumberController;
    }

    public void playGame() {
        while (gameState.getState() != GameState.END_STATE) {
            makeAnotherSuggestion(gameNumberController.randomComputerNumberGenerator());
        }
        Output.gameSucceeded();
        gameState.checkGameRetryOrEnd(Input.retryOrEnd());
    }

    public void makeAnotherSuggestion(List<Integer> computer) {
        while (gameState.getState() != GameState.GAME_SUCCEED_STATE) {
            GameScore gameScore = new GameScore(gameNumberController.suggestedNumberConverter(Input.numberSuggestion()), computer);
            Output.drawOutResult(gameScore.getBall(), gameScore.getStrike());
            gameState.checkGameSucceeded(gameScore.getStrike());
        }
    }
}
