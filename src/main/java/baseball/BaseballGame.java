package baseball;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class BaseballGame {
    private static final int BASEBALL_NUMBER_SIZE = 3;
    public List<Integer> createComputerNumbers() {
        return pickUniqueNumbersInRange(1,9, BASEBALL_NUMBER_SIZE);
    }
}
