package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int INPUT_NUMBER_LENGTH = 3;
    private static final int START_NUMBER = 1;
    private static final int LAST_NUMBER = 9;
    // 문제 내라 (요청)
    public static List<Integer> selectNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < INPUT_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER, LAST_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

}
