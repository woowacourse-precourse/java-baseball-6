package baseball.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * 볼과 스트라이크의 개수를 카운트하는 역할을 수행한다.
 */
public class BallCounter {

    private static final int INITIAL_COUNT = 0;
    private static final int INCREMENT_COUNT = 1;

    private static final Map<PitchResult, Integer> ballCounter = new HashMap<>();

    private BallCounter() {
    }

    /**
     * 볼 개수를 1 증가시킨다.
     */
    public static void countBall() {
        ballCounter.put(PitchResult.BALL, getCountOfBall() + INCREMENT_COUNT);
    }

    /**
     * 스트라이크 개수를 1 증가시킨다.
     */
    public static void countStrike() {
        ballCounter.put(PitchResult.STRIKE, getCountOfStrike() + INCREMENT_COUNT);
    }

    /**
     * 카운트 결과가 모두 스트라이크인지 여부를 판단한다.
     */
    public static boolean isAllStrike(int digitNumber) {
        return getCountOfStrike() == digitNumber;
    }

    /**
     * 볼과 스트라이크의 개수를 초기화한다.
     */
    public static void reset() {
        ballCounter.replace(PitchResult.BALL, INITIAL_COUNT);
        ballCounter.replace(PitchResult.STRIKE, INITIAL_COUNT);
    }

    public static int getCountOfBall() {
        return ballCounter.getOrDefault(PitchResult.BALL, INITIAL_COUNT);
    }

    public static int getCountOfStrike() {
        return ballCounter.getOrDefault(PitchResult.STRIKE, INITIAL_COUNT);
    }
}
