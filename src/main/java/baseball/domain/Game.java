package baseball.domain;

import baseball.view.View;

import java.util.List;

public class Game {
    private final Computer computer;
    private final List<Integer> targetNumber;
    private boolean isGameEnd;

    private Game(Computer computer) {
        this.computer = computer;
        this.targetNumber = computer.generateTargetNumber();
    }

    public static Game makeNewGame(Computer computer) {
        return new Game(computer);
    }

    public void start() {
        while (!isGameEnd) {
            String playerNumber = View.readPlayerNumber();
            GameResult gameResult = new GameResult();
            gameResult.calculate(targetNumber, playerNumber);
            View.printResultMessage(gameResult);
            checkGameOver(gameResult);
        }
    }

    private void checkGameOver(GameResult gameResult) {
        if (gameResult.isEnd()) {
            String command = View.readGameEndCommand();
            computer.checkFinishCommand(command);
            isGameEnd = true;
        }
    }
}
