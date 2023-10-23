package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameController {

    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String SUCCESS_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_ERROR_MESSAGE = "1 또는 2를 입력해주세요.";
    private final Computer computer = new Computer();
    private final User user = new User();
    private String computerNumber;
    private String userNumber;
    private boolean gameOver = false;

    public void play() {

        System.out.println(START_GAME_MESSAGE);
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
            System.out.println(SUCCESS_GAME_MESSAGE);
            System.out.println(RESTART_GAME_MESSAGE);
            String restart = Console.readLine();

            if (restart.equals("1")) {
                startGame();
            } else if (restart.equals("2")) {
                gameOver = true;
            } else {
                throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
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
