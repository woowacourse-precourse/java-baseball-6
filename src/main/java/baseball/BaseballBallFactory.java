package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class BaseballBallFactory {
    private final static int BALL_LENGTH = 3;
    private final static int MIN_BALL_NUMBER = 1;
    private final static int MAX_BALL_NUMBER = 9;

    public static BallArray createRanDomBall() {
        Set<Integer> intHashSet = new HashSet<>();
        while (intHashSet.size() < BALL_LENGTH) {
            intHashSet.add(Randoms.pickNumberInRange(MIN_BALL_NUMBER,MAX_BALL_NUMBER));
        }
        StringBuilder result = new StringBuilder();
        for (int i : intHashSet) {
            result.append(i);
        }
        return new BallArray(Integer.parseInt(result.toString()));
    }

    public static BallArray createManualBall(int number){
        if ((int) (Math.log10(number) + 1) > BALL_LENGTH) {
            throw new IllegalArgumentException();
        }
        return new BallArray(number);
    }
}
