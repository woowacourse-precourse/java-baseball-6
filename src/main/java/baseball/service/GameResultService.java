package baseball.service;

import baseball.model.ComputerNumber;
import baseball.model.UserNumber;

import java.util.List;

public class GameResultService {
    private boolean isNothing = false;
    private int ballCount = 0;
    private int strikeCount = 0;

    private GameResultService(ComputerNumber computerNumber, UserNumber userNumber) {
        calculateResult(computerNumber.getNumbers(), userNumber.getNumbers());
    }

    public static GameResultService of(ComputerNumber computerNumber, UserNumber userNumber) {
        return new GameResultService(computerNumber, userNumber);
    }

    public boolean isNothing() {
        return isNothing;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean isThreeStrike() {
        return strikeCount == 3;
    }

    private void calculateResult(List<Integer> computerNumber, List<Integer> playerNumber) {
        if (isEqualNumbers(computerNumber, playerNumber)) {
            strikeCount = 3;
            return;
        }

        calculateBallAndStrikeCount(computerNumber, playerNumber);

        if (isBallAndStrikeZero()) {
            isNothing = true;
        }
    }

    private boolean isEqualNumbers(List<Integer> computerNumber, List<Integer> playerNumber) {
        return computerNumber.equals(playerNumber);
    }

    private void calculateBallAndStrikeCount(List<Integer> computerNumber, List<Integer> playerNumber) {
        for (int i = 0; i < playerNumber.size(); i++) {
            if (isSameNumberExist(computerNumber, playerNumber.get(i))) {
                if (isSamePosition(computerNumber.get(i), playerNumber.get(i))) {
                    strikeCount++;
                    continue;
                }
                ballCount++;
            }
        }
    }

    private boolean isSameNumberExist(List<Integer> computerNumber, Integer playerNumber) {
        return computerNumber.contains(playerNumber);
    }

    private boolean isSamePosition(Integer computerNumber, Integer playerNumber) {
        return computerNumber.equals(playerNumber);
    }

    private boolean isBallAndStrikeZero() {
        return ballCount == 0 && strikeCount == 0;
    }
}
