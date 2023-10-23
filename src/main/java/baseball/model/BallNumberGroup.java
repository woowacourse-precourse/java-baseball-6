package baseball.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BallNumberGroup {
    private static final int BALL_NUMBER_GROUP_SIZE = 3;
    private List<BallNumber> BallNumberGroup;

    public BallNumberGroup(List<BallNumber> ballNumberGroup) {
        validateBallNumberGroupSize(ballNumberGroup);
        validateBallNumberIsUniqueNumber(ballNumberGroup);
        this.BallNumberGroup = ballNumberGroup;
    }

    private void validateBallNumberGroupSize(List<BallNumber> ballNumberGroup) {
        if (ballNumberGroup.size() != BALL_NUMBER_GROUP_SIZE) {
            throw new IllegalArgumentException("공의 개수는 3개여야 합니다.");
        }
    }

    private void validateBallNumberIsUniqueNumber(List<BallNumber> ballNumberGroup) {
        Set<Integer> ballNumberSet = new HashSet<>();

        for (BallNumber ballNumber : ballNumberGroup) {
            ballNumberSet.add(ballNumber.getNumber());
        }

        if (ballNumberGroup.size() != ballNumberSet.size()) {
            throw new IllegalArgumentException("모든 공은 서로 다른 임의의 숫자여야 합니다.");
        }
    }
}