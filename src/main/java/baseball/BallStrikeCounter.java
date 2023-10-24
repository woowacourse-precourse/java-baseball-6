package baseball;

import java.util.List;

public class BallStrikeCounter {

    private static final int NUMBER_LENGTH = 3;
    private int ballCount;
    private int strikeCount;
    private final List<Integer> userNumbers;
    private final List<Integer> computerNumbers;

    public BallStrikeCounter(List<Integer> computerNumbers, List<Integer> userNumbers) {
        this.computerNumbers = computerNumbers;
        this.userNumbers = userNumbers;

        ballCount = 0;
        strikeCount = 0;
    }

    public void countBallAndStrikes() {
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            countBallAndStrike(computerNumbers.get(i), userNumbers.get(i));
        }
    }

    public void countBallAndStrike(Integer computerNumber, Integer userNumber) {
        if (computerNumbers.contains(userNumber)) {
            if (computerNumber.equals(userNumber)) {
                strikeCount++;
            } else {
                ballCount++;
            }
        }
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
