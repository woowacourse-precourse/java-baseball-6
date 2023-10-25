package baseball.domain;

import baseball.SYSTEM_VALUE.GameStatusValue;

public class GameManager {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.\n";
    private final ConsoleManager consoleManager = new ConsoleManager();
    private BallNumber targetNumber;

    public void run() {
        System.out.println(GAME_START_MESSAGE);
        startGame();
    }

    public void makeComputerNumber() {
        targetNumber = new BallNumber(RandomNumberGenerator.makeComputerNumber());
    }

    public Score computeUserScore(int userInput) {
        BallNumber userNumber = new BallNumber(userInput);
        return ScoreCalculator.createScore(userNumber, targetNumber);
    }

    private void startGame() {
        int userInput;
        do {
            makeComputerNumber();
            loopGame();
            userInput = consoleManager.readGameControlInput();
        } while (userInput != GameStatusValue.GAME_EXIT);
    }

    private void loopGame() {
        Score score;
        do {
            // 게임시작
            int userInput = consoleManager.readGameInput();
            score = computeUserScore(userInput);
            consoleManager.printResult(score);
        } while (!score.isGameOver());
    }
}
