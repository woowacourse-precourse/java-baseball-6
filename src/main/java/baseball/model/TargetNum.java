package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;


public class TargetNum {

    public final static int TARGET_LENGTH = 3;
    private final static int START_NUM = 1;
    private final static int END_NUM = 9;
    private final static int[] target = new int[TARGET_LENGTH];

    public TargetNum() {
        Set<Integer> targetSet = new LinkedHashSet<>();

        while(targetSet.size() != TARGET_LENGTH) {
            targetSet.add(Randoms.pickNumberInRange(START_NUM, END_NUM));
        }

        int idx = 0;
        for (int targetSetValue : targetSet) {
            target[idx] = targetSetValue;
            idx++;
        }
    }

    public int[] getTarget() {
        return target;
    }
}


