package baseball.domain;

import java.util.List;

import static baseball.domain.Game.NUM_DIGITS;
import static baseball.util.OutputUtil.printChooseOptionMessage;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameManager {
    private static final String RESTART = "1";
    private static final String END = "2";
    private Integer balls;
    private Integer strikes;
    private boolean isNumberCorrect;
    private GameResult gameResult;
    public GameManager() {
        strikes = 0;
        balls = 0;
        isNumberCorrect = false;
        gameResult = new GameResult();
    }

    public void checkGuessResult(List<Integer> targetNumber, List<Integer> guessNumber) {
        int balls = calculateBalls(targetNumber, guessNumber);
        int strikes = calculateStrikes(targetNumber, guessNumber);
        createResultString(strikes, balls);
    }

    public boolean checkIsCorrectNumber() {
        if (strikes == NUM_DIGITS) {
            isNumberCorrect = true;
            gameResult.addCorrectMessage();
        }
        return isNumberCorrect;
    }

    public boolean checkRestartGame() {
        printChooseOptionMessage();
        switch (readLine()) {
            case RESTART:
                return true;
            case END:
                return false;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void createResultString(Integer strikes, Integer balls) {
        if (balls > 0) {
            gameResult.addBallCount(balls);
        }
        if (strikes > 0) {
            gameResult.addStrikeCount(strikes);
        }
        if (gameResult.isResultBlank()) {
            gameResult.addNothingMessage();
        }
    }

    private int calculateStrikes(List<Integer> targetNumber, List<Integer> guessNumber) {
        for (int i = 0; i < NUM_DIGITS; i++) {
            if (targetNumber.get(i).equals(guessNumber.get(i))) {
                strikes++;
            }
        }
        return strikes;
    }

    private int calculateBalls(List<Integer> targetNumber, List<Integer> guessNumber) {
        for (int i = 0; i < NUM_DIGITS; i++) {
            if (targetNumber.contains(guessNumber.get(i)) && !targetNumber.get(i).equals(guessNumber.get(i))) {
                balls++;
            }
        }
        return balls;
    }

    public void displayResult() {
        gameResult.displayResult();
    }
}
