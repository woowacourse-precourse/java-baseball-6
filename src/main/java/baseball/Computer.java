package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int NUMBER_LEN = 3;
    private static final int MIN_VAL = 1;
    private static final int MAX_VAL = 9;
    public List<Integer> computerAnswer = new ArrayList<Integer>();

    public Computer() {
        boolean[] isUsed = new boolean[MAX_VAL + 1];

        for (int i = 0; i < NUMBER_LEN; ) {
            int tmp = Randoms.pickNumberInRange(MIN_VAL, MAX_VAL);
            if (!isUsed[tmp]) {
                isUsed[tmp] = true;
                computerAnswer.add(tmp);
                i++;
            }
        }
    }


}
