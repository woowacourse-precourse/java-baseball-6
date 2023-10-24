package baseball.service;

import java.util.ArrayList;
import java.util.List;

public class GameNumberCalculatorService {
    private static final int NUMBER_LENGTH = 3;
    private int ballCount;
    private int strikeCount;
    private List<Integer> strikeAndBallCountList = new ArrayList<>();

    public List<Integer> calculateGameNumber(List<Integer> userNumbers, List<Integer> computerNumbers) {
        resetCalculator();
        setStrikeAndBallCountList(getStrikeCount(userNumbers, computerNumbers), getBallCount(userNumbers, computerNumbers));
        return strikeAndBallCountList;
    }

    public void setStrikeAndBallCountList(int strikeCount, int ballCount) {
        strikeAndBallCountList.add(strikeCount);
        strikeAndBallCountList.add(ballCount);
    }

    public int getStrikeCount(List<Integer> userNumbers, List<Integer> computerNumbers) {
        countStrike(userNumbers, computerNumbers);
        return strikeCount;
    }

    public void countStrike(List<Integer> userNumbers, List<Integer> computerNumbers) {
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (isStrike(userNumbers.get(i), computerNumbers.get(i))) {
                strikeCount++;
            }
        }
    }

    public boolean isStrike(int userNumber, int computerNumber) {
        if (userNumber == computerNumber) {
            return true;
        }
        return false;
    }

    public int getBallCount(List<Integer> userNumbers, List<Integer> computerNumbers) {
        countBall(userNumbers, computerNumbers);
        return ballCount;
    }

    public void countBall(List<Integer> userNumbers, List<Integer> computerNumbers) {
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computerNumbers.contains(userNumbers.get(i)) && computerNumbers.get(i) != userNumbers.get(i)) {
                ballCount++;
            }
        }
    }

    public void resetCalculator() {
        strikeAndBallCountList.clear();
        ballCount = 0;
        strikeCount = 0;
    }
}