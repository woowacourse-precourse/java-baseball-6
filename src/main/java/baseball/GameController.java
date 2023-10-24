package baseball;

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
        if (result.equals("3스트라이크")) {
            System.out.println(GameMessage.SUCCESS_GAME_MESSAGE.getMessage());
            System.out.println(GameMessage.RESTART_GAME_MESSAGE.getMessage());
            String restart = Console.readLine();

            if (restart.equals("1")) {
                startGame();
            } else if (restart.equals("2")) {
                gameOver = true;
            } else {
                throw new IllegalArgumentException(GameMessage.INPUT_ERROR_MESSAGE.getMessage());
            }
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
