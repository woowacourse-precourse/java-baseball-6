package baseball;

import java.util.List;

public class GamePlayer {
        private final GameState gameState;
        private final GameNumber gameNumber;

        public GamePlayer(GameState gameState, GameNumber gameNumber) {
                this.gameState = gameState;
                this.gameNumber = gameNumber;
        }

        public void playGame() {
                while (!gameState.isEndState()) {
                        makeAnotherSuggestion(gameNumber.generateRandomComputerNumber());
                        Output.notifyGameSuccess();
                        gameState.checkGameRetryOrEnd(Input.chooseRetryOrEnd());
                }
        }

        private void makeAnotherSuggestion(List<Integer> computer) {
                while (!gameState.isGameSucceedState()) {
                        GameScore gameScore = new GameScore(gameNumber.modifyNumberSuggestion(Input.makeNumberSuggestion()), computer);
                        Output.drawOutResult(gameScore.calculateBall(), gameScore.calculateStrike());
                        gameState.checkGameSuccess(gameScore.calculateStrike());
                }
        }
}
