package baseball.controller;

import baseball.model.BallCount;
import baseball.model.Computer;
import baseball.model.GameMessage;
import baseball.model.GameResult;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private final Computer computer = new Computer();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private String computerNumber;
    private String userNumber;
    private boolean gameOver = false;

    public void play() {

        outputView.printStartGameMessage();
        startGame();

        while (!gameOver) {
            getUserNumber();
            BallCount ballCount = new BallCount(computerNumber, userNumber);
            GameResult gameResult = new GameResult(ballCount.getBall(), ballCount.getStrike());
            outputView.printGameResult(gameResult.getResult());
            confirmRestart(gameResult.getResult());
        }

    }

    private void confirmRestart(String result) {
        String endCondition = "3스트라이크";
        if (result.equals(endCondition)) {
            outputView.printSuccessGameMessage();
            outputView.printRestartGameMessage();
            String restart = inputView.userInput();

            restartOrEnd(restart);
        }
    }

    private void restartOrEnd(String restart) {
        String restartNumber = "1";
        String endNumber = "2";
        if (restart.equals(restartNumber)) {
            startGame();
        } else if (restart.equals(endNumber)) {
            gameOver = true;
        } else {
            throw new IllegalArgumentException(GameMessage.INPUT_RESTART_ERROR_MESSAGE.getMessage());
        }
    }

    private void getUserNumber() {
        outputView.printInputNumberMessage();
        inputView.setUserInputNumber();
        userNumber = inputView.getUserInputNumber();
    }

    private void startGame() {
        computer.makeComputerRandomNumber();
        computerNumber = computer.getComputerRandomNumber();
    }
}
