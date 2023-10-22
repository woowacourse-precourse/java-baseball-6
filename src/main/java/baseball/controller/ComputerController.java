package baseball.controller;

import baseball.model.GameNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ComputerController {
    private static final int GAME_FINISH_STRIKE_NUMBER = 3;
    private static final int INIT_ZERO = 0;
    private int strikeCount;
    private int ballCount;

    RandomUtility randomUtility = new RandomUtility();

    public void startGame(GameNumber gameNumber) {
        List<Integer> computerGenerateNumbers = Arrays.stream(randomUtility.generateAnswerNumbers()).boxed().collect(Collectors.toList());
        gameNumber.setComputerGenerateNumbers(computerGenerateNumbers);
    }

    public void initStrikeAndBallCount() {
        strikeCount = INIT_ZERO;
        ballCount = INIT_ZERO;
    }

    public boolean checkUserInputWithAnswer(List<Integer> userInputNumbers, List<Integer> computerGenerateNumbers) {
        initStrikeAndBallCount();
        checkStrikeAndBall(userInputNumbers, computerGenerateNumbers);
        return isThreeStrikes();
    }

    private boolean isThreeStrikes() {
        if (strikeCount == GAME_FINISH_STRIKE_NUMBER) {
            return true;
        }
        return false;
    }

    private void checkStrikeAndBall(List<Integer> userInputNumbers, List<Integer> computerGenerateNumbers) {
        for (int i = 0; i < userInputNumbers.size(); i++) {
            countStrike(userInputNumbers.get(i), computerGenerateNumbers.get(i));
            countBall(computerGenerateNumbers, userInputNumbers.get(i), i);
        }
    }

    private void countStrike(int userInputNumber, int computerGenerateNumber) {
        if (userInputNumber == computerGenerateNumber) {
            strikeCount++;
        }
    }

    private void countBall(List<Integer> computerGenerateNumbers, int userInputNumber, int index) {
        if (userInputNumber != computerGenerateNumbers.get(index) && computerGenerateNumbers.contains(userInputNumber)) {
            ballCount++;
        }
    }
}
