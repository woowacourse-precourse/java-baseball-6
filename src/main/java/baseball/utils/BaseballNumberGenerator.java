package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballNumberGenerator {
    private static final int MAX_BASEBALL_NUMBER_SIZE = 3;
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;


    public static List<Integer> generate() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < MAX_BASEBALL_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return Collections.unmodifiableList(computer);
    }
}
