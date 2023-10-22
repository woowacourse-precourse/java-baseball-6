package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private final int num;
    public static final int numberCount = 3;

    private static final int minimumNumber = 1;
    private static final int maximumNumber = 9;
    private static final List<Integer> goalNumbers = new ArrayList<>(numberCount);

    static {
        setGoalNumbers();
    }

    public Number(int num) {
        this.num = num;
    }

    private static void setGoalNumbers() {
        for (int i = 0; i < numberCount; i++) {
            int randomNumber = Randoms.pickNumberInRange(minimumNumber, maximumNumber);
            if (!goalNumbers.contains(randomNumber)) {
                goalNumbers.set(i, randomNumber);
            }
        }
    }

    }
}
