package baseball.controller;

import java.util.Arrays;
import baseball.model.GameNumber;
import baseball.view.OutputView;

public class ComputerController {
    private static final int BASEBALL_NUMBER_LENGTH = 3;
    private static final int BASEBALL_SUCCESS_STRIKE_COUNT = 3;
    private static final int RESET_COUNT = 0;
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private int strikeCount;
    private int ballCount;
    OutputView outputView = new OutputView();

    public void startGame(GameNumber gameNumber) {
        gameNumber.setRandomNumbers();
    }
    
    public void compareNumbers(GameNumber gameNumber) {
        int[] playerNumbers = gameNumber.getPlayerNumbers();
        int[] randomNumbers = gameNumber.getRandomNumbers();
        
        resetCount();

        for (int i = 0; i < BASEBALL_NUMBER_LENGTH; i++) {
            countStrike(randomNumbers, playerNumbers[i], i);
            countBall(randomNumbers, playerNumbers[i], i);
        }
    }

    private void resetCount() {
        strikeCount = RESET_COUNT;
        ballCount = RESET_COUNT;
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

        hint += getBallHint();
        hint += getStrikeHint();
        hint += getNothingHint();

        outputView.printHint(hint);

    }

    private String getBallHint() {
        if (ballCount > 0) {
            return ballCount + BALL_MESSAGE + " ";
        }
        return "";
    }

    private String getStrikeHint() {
        if (strikeCount > 0) {
            return strikeCount + STRIKE_MESSAGE + " ";
        }
        return "";
    }

    private String getNothingHint() {
        if (ballCount == 0 && strikeCount == 0) {
            return NOTHING_MESSAGE;
        }
        return "";
    }

    public boolean isSuccessGame() {
        return strikeCount == BASEBALL_SUCCESS_STRIKE_COUNT;
    }
}
