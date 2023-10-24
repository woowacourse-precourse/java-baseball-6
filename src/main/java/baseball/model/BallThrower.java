package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BallThrower {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;
    private static final int THROW_BALL_NUMBER = 3;

    public static List<Integer> ThrowBall() {
        Set<Integer> ballSet = new HashSet<>();
        while (ballSet.size() < THROW_BALL_NUMBER) {
            ballSet.add(Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER));
        }

        return new ArrayList<>(ballSet);
    }
}
