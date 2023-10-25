package baseball.domain;

import baseball.SYSTEM_VALUE.GameStatusValue;
import baseball.controller.BallNumberVerifier;
import baseball.controller.GameStatusVerifier;

public class GameManager {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.\n";
    private final ConsoleManager consoleManager = new ConsoleManager();

    private final GameController gameController = new GameController();

    public GameStatusVerifier gameStatusVerifier = new GameStatusVerifier();
    public BallNumberVerifier ballNumberVerifier = new BallNumberVerifier();
    private BallNumber targetNumber;

    public void run() {
        System.out.println(GAME_START_MESSAGE);
        startGame();
    }

    private void startGame() {
        int userInput;
        do {
            gameController.makeComputerNumber();
            loopGame();
            userInput = consoleManager.readGameControlInput();
        } while (userInput != GameStatusValue.GAME_EXIT && userInput != GameStatusValue.GAME_RESTART);
    }

    private void loopGame() {
        Score score;
        do {
            int userInput = consoleManager.readGameInput();
            if (userInput == GameStatusValue.GAME_EXIT) {
                return;
            }
            score = gameController.computeUserScore(userInput);
            consoleManager.printResult(score);
        } while (!score.isGameOver());
    }
}
