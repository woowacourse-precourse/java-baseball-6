package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomTargetNumber implements Numbers {
    private static final int LENGTH = 3;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;
    private List<Integer> numContainer;

    private RandomTargetNumber() {}

    public static RandomTargetNumber generate() {
        RandomTargetNumber newInstance = new RandomTargetNumber();
        List<Integer> nc = new ArrayList<>(3);
        while (nc.size() < LENGTH) {
            int randomizedNum = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
            if (!nc.contains(randomizedNum)) {
                nc.add(randomizedNum);
            }
        }
        newInstance.numContainer = Collections.unmodifiableList(nc);
        return newInstance;
    }

    @Override
    public int firstNumber() {
        return this.numContainer.get(0);
    }

    @Override
    public int secondNumber() {
        return this.numContainer.get(1);
    }

    @Override
    public int thirdNumber() {
        return this.numContainer.get(2);
    }

    @Override
    public List<Integer> allNumbers() {
        return new ArrayList<>(this.numContainer);
    }

    @Override
    public String toString() {
        return String.valueOf(this.numContainer.get(0)) + this.numContainer.get(1) + this.numContainer.get(2);
    }
}
