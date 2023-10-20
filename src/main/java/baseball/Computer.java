package baseball;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Computer {
    public List<Integer> createComputerNumbers() {
        return pickUniqueNumbersInRange(1, 9, Constants.BASEBALL_NUMBER_SIZE);
    }
}
