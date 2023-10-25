package baseball.domain;

import java.util.List;

import static baseball.util.OutputUtil.printStartMessage;

public class Game {
    public static final int NUM_DIGITS = 3;
    private Computer computer;
    private Player player;
    private GameManager gameManager;
    private boolean isGameOver;

    public void gameStart() {
        boolean isRestart = true;
        while (isRestart) {
            resetGame();
            gamePlay();
            isRestart = gameManager.checkRestartGame();
        }
    }

    private void gamePlay() {
        printStartMessage();
        while (!isGameOver) {
            gameManager = new GameManager();
            player.generateGuessNumber();
            gameManager.checkGuessResult(getComputerTargetNumber(), getPlayerGuessNumber());
            if (gameManager.checkIsCorrectNumber()) {
                gameOver();
            }
            gameManager.displayResult();
        }
    }

    private void resetGame() {
        computer = new Computer();
        player = new Player();
        isGameOver = false;
    }

    private List<Integer> getPlayerGuessNumber() {
        return player.getGuessNumber();
    }

    private List<Integer> getComputerTargetNumber() {
        return computer.getTargetNumber();
    }

    private void gameOver() {
        isGameOver = true;
    }
}
