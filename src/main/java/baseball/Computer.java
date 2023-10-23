package baseball;

import camp.nextstep.edu.missionutils.Randoms;현
import java.util.List;

public class Computer {

    private static final int NUMBER_START_RANGE = 1;
    private static final int NUMBER_END_RANGE = 9;

    public List<Integer> createCorrectAnswer() {
        Randoms.pickNumberInRange(NUMBER_START_RANGE, NUMBER_END_RANGE);
    }


}
