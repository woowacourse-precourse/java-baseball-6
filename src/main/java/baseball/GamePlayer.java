package baseball;

import java.util.List;

public class GamePlayer {
    private final GameStatus gameStatus;
    private final GameNumber gameNumber;

    public GamePlayer(GameStatus gameStatus, GameNumber gameNumber) {
        this.gameStatus = gameStatus;
        this.gameNumber = gameNumber;
    }

    public void playGame() {
        while (!gameStatus.isEndStatus()) {
            playRound(gameNumber.generateComputerNumber());
            Output.printGameSuccessMessage();
            gameStatus.checkGameStatusDecision(Input.inputGameStatusDecision());
        }
    }

    private void playRound(List<Integer> computer) {
        while (!gameStatus.isGameSuccessStatus()) {
            List<Integer> user = gameNumber.convertUserNumber(Input.inputUserNumber());
            GameScore gameScore = new GameScore(user, computer);
            Output.printRoundScore(gameScore.calculateBall(), gameScore.calculateStrike());

            gameStatus.checkGameSuccess(gameScore.calculateStrike());
        }
    }
}