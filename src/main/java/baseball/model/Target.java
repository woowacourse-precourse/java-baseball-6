package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class Target {
    public static final int BALL_SIZE = 3;
    private static final  int OVER_VALUE = 1;
    private static final int UNDER_VALUE = 9;
    private final int[] targetNum = new int[BALL_SIZE];

    public Target() {
        Set<Integer> targetSet = new LinkedHashSet<>();

        while (targetSet.size() != BALL_SIZE) {
            targetSet.add(Randoms.pickNumberInRange(OVER_VALUE, UNDER_VALUE));
        }

        int idx = 0;
        for (int targetSetValue : targetSet) {
            targetNum[idx] = targetSetValue;
            idx++;
        }
    }

    public int[] getTargetNum() {
        return targetNum;
    }
}
