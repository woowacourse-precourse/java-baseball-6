package baseball.controller;

import baseball.model.BallCount;
import baseball.model.Computer;
import baseball.model.GameMessage;
import baseball.model.GameResult;
import baseball.view.User;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    private final Computer computer = new Computer();
    private final User user = new User();
    private String computerNumber;
    private String userNumber;
    private boolean gameOver = false;


    public void play() {

        System.out.println(GameMessage.START_GAME_MESSAGE.getMessage());
        startGame();

        while (!gameOver) {
            getUserNumber();

            BallCount ballCount = new BallCount(computerNumber, userNumber);
            GameResult gameResult = new GameResult(ballCount.getBall(), ballCount.getStrike());

            confirmRestart(gameResult.getResult());
        }

    }

    private void confirmRestart(String result) {
        String endCondition = "3스트라이크";
        if (result.equals(endCondition)) {
            System.out.println(GameMessage.SUCCESS_GAME_MESSAGE.getMessage());
            System.out.println(GameMessage.RESTART_GAME_MESSAGE.getMessage());
            String restart = Console.readLine();

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
        user.setUserInputNumber();
        userNumber = user.getUserInputNumber();
    }

    private void startGame() {
        computer.makeComputerRandomNumber();
        computerNumber = computer.getComputerRandomNumber();
    }
}
