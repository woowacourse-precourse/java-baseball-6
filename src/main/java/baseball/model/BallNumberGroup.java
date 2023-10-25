package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BallNumberGroup {
    private static final int BALL_NUMBER_GROUP_SIZE = 3;
    private List<BallNumber> BallNumberGroup;

    public BallNumberGroup(List<Integer> ballNumbers) {
        validateBallNumberGroupSize(ballNumbers);
        validateBallNumberIsUniqueNumber(ballNumbers);
        List<BallNumber> ballNumberGroup = new ArrayList<>();

        for (Integer ballNumber : ballNumbers) {
            ballNumberGroup.add(new BallNumber(ballNumber));
        }

        this.BallNumberGroup = ballNumberGroup;
    }

    public List<BallNumber> getBallNumberGroup() {
        return BallNumberGroup;
    }

    private void validateBallNumberGroupSize(List<Integer> ballNumberGroup) {
        if (ballNumberGroup.size() != BALL_NUMBER_GROUP_SIZE) {
            throw new IllegalArgumentException("공의 개수는 3개여야 합니다.");
        }
    }

    private void validateBallNumberIsUniqueNumber(List<Integer> ballNumberGroup) {
        Set<Integer> ballNumberSet = new HashSet<>(ballNumberGroup);

        if (ballNumberGroup.size() != ballNumberSet.size()) {
            throw new IllegalArgumentException("모든 공은 서로 다른 임의의 숫자여야 합니다.");
        }
    }
}