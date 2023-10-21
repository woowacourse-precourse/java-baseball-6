package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private static final int NUMBER_LEN = 3;
    private static final int MIN_VAL = 1;
    private static final int MAX_VAL = 9;
    private int[] answer = new int[NUMBER_LEN];

    public Computer() {
        boolean[] isUsed = new boolean[MAX_VAL + 1];

        for (int i = 0; i < NUMBER_LEN; ) {
            int tmp = Randoms.pickNumberInRange(MIN_VAL, MAX_VAL);
            if (isUsed[tmp] != true) {
                isUsed[tmp] = true;
                answer[i++] = tmp;
            }
        }
    }


}
