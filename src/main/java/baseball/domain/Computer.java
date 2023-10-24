package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Computer {
    private final List<Integer> result;

    public Computer() {
        result = initResult();
    }

    public List<Integer> getResult() {
        return result;
    }

    private static List<Integer> initResult() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }
}
