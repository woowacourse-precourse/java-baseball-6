package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Oppoent {
    public static final int DESIGNED_NUM = 3;
    public static final int START_NUM = 1;
    public static final int LAST_NUM = 9;
    private static final boolean VALID_SUCCESS = true;
    private static final boolean VALID_FAILED = false;

    private void generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < DESIGNED_NUM) {
            int randomNumber = Randoms.pickNumberInRange(START_NUM, LAST_NUM);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
}
