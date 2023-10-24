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
                while (!gameState.isEndState()) {
                        makeAnotherSuggestion(gameNumberController.randomComputerNumberGenerator());
                        Output.gameSucceeded();
                        gameState.checkGameRetryOrEnd(Input.retryOrEnd());
                }
        }

        private void makeAnotherSuggestion(List<Integer> computer) {
                while (!gameState.isGameSucceedState()) {
                        GameScore gameScore = new GameScore(gameNumberController.suggestedNumberConverter(Input.numberSuggestion()), computer);
                        Output.drawOutResult(gameScore.getBall(), gameScore.getStrike());
                        gameState.checkGameSucceeded(gameScore.getStrike());
                }
        }
}
