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
            makeAttempt(gameNumber.generateRandomComputerNumber());
            Output.notifyGameSuccess();
            gameState.checkGameRetryOrEnd(Input.chooseRetryOrEnd());
        }
    }

    private void makeAttempt(List<Integer> computer) {
        while (!gameState.isGameSuccessState()) {
            GameScore gameScore = new GameScore(gameNumber.modifyNumberSuggestion(Input.inputNumberSuggestion()),
                    computer);
            Output.notifyGameScore(gameScore.calculateBall(), gameScore.calculateStrike());
            gameState.checkGameSuccess(gameScore.calculateStrike());
        }
    }
}
