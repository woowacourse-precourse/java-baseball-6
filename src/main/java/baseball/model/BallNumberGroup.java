package baseball.model;

import baseball.ExceptionMessage;
import baseball.GameMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BallNumberGroup {
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
        if (ballNumberGroup.size() != GameMessage.BALL_NUMBER_GROUP_SIZE.getNumber()) {
            throw new IllegalArgumentException(ExceptionMessage.ILLEGAL_BASEBALL_SIZE.getMessage());
        }
    }

    private void validateBallNumberIsUniqueNumber(List<Integer> ballNumberGroup) {
        Set<Integer> ballNumberSet = new HashSet<>(ballNumberGroup);

        if (ballNumberGroup.size() != ballNumberSet.size()) {
            throw new IllegalArgumentException(ExceptionMessage.ILLEGAL_UNIQUE_BASEBALL_GROUP.getMessage());
        }
    }
}