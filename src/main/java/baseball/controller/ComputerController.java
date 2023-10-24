package baseball.controller;

import java.util.List;
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
    RandomUtility randomUtility = new RandomUtility();

    public void startGame(GameNumber gameNumber) {
        List<Integer> randomNumbers = randomUtility.generateRandomNumbers();
        gameNumber.setRandomNumbers(randomNumbers);
    }

    public boolean playGame(GameNumber gameNumber) {
        List<Integer> playerNumbers = gameNumber.getPlayerNumbers();
        List<Integer> randomNumbers = gameNumber.getRandomNumbers();

        compareNumbers(playerNumbers, randomNumbers);

        return isSuccessGame();
    }

    private void compareNumbers(List<Integer> playerNumbers, List<Integer> randomNumbers) {
        resetCount();
        checkStrikeAndBall(playerNumbers, randomNumbers);
        provideHint();
    }

    private void resetCount() {
        strikeCount = RESET_COUNT;
        ballCount = RESET_COUNT;
    }

    private void checkStrikeAndBall(List<Integer> playerNumbers, List<Integer> randomNumbers) {
        for (int i = 0; i < BASEBALL_NUMBER_LENGTH; i++) {
            countStrike(randomNumbers.get(i), playerNumbers.get(i));
            countBall(randomNumbers, playerNumbers.get(i), i);
        }
    }

    private void countStrike(int randomNumber, int playerNumber) {
        if (randomNumber == playerNumber) {
            strikeCount++;
        }
    }

    private void countBall(List<Integer> randomNumbers, int playerNumber, int numberIndex) {
        if ((randomNumbers.get(numberIndex) != playerNumber)
                && randomNumbers.contains(playerNumber)) {
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

    private boolean isSuccessGame() {
        return strikeCount == BASEBALL_SUCCESS_STRIKE_COUNT;
    }
}
