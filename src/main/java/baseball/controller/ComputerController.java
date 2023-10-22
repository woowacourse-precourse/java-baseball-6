package baseball.controller;

import java.util.Arrays;
import baseball.model.GameNumber;
import baseball.view.OutputView;

public class ComputerController {
    OutputView outputView = new OutputView();
    
    private static final int BASEBALL_NUMBER_LENGTH = 3;
    private static final int BASEBALL_SUCCESS_STRIKE_COUNT = 3;
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private int strikeCount;
    private int ballCount;

    public void startGame(GameNumber gameNumber) {
        outputView.printStartGame();
        gameNumber.setRandomNumbers();
    }
    
    public void compareNumbers(GameNumber gameNumber) {
        int[] playerNumbers = gameNumber.getPlayerNumbers();
        int[] randomNumbers = gameNumber.getRandomNumbers();

        for (int i = 0; i < BASEBALL_NUMBER_LENGTH; i++) {
            countStrike(randomNumbers, playerNumbers[i], i);
            countBall(randomNumbers, playerNumbers[i], i);
        }
    }

    private void countStrike(int[] randomNumbers, int playerNumber, int numberIndex) {
        if (randomNumbers[numberIndex] == playerNumber) {
            strikeCount++;
        }
    }

    private void countBall(int[] randomNumbers, int playerNumber, int numberIndex) {
        if ((randomNumbers[numberIndex] != playerNumber) && Arrays.stream(randomNumbers).anyMatch(num -> num == playerNumber)) {
            ballCount++;
        } 
    }

    public void provideHint() {
        String hint = "";

        if (ballCount > 0) {
            hint += ballCount + BALL_MESSAGE + " ";
        }

        if (strikeCount > 0) {
            hint += strikeCount + STRIKE_MESSAGE + " ";
        }

        if (ballCount == 0 && strikeCount == 0) {
            hint += NOTHING_MESSAGE;
        }

        System.out.println(hint);
    }

    public boolean isSuccessGame() {
        return strikeCount == BASEBALL_SUCCESS_STRIKE_COUNT;
    }
}
