package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumbers {
    private final static int MAX_LENGTH = 3;
    private final static int START_INCLUSIVE = 1;
    private final static int END_INCLUSIVE = 9;
    private final int[] numsArray;

    RandomNumbers() {
        numsArray = new int[MAX_LENGTH];
        int i = 0;

        while (true) {
            boolean isSame = false;

            if (i == MAX_LENGTH) {
                break;
            }
            numsArray[i] = pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            for (int j = 0; j < i; j++) {
                if (numsArray[j] == numsArray[i]) {
                    isSame = true;
                    break;
                }
            }
            if (isSame) {
                continue;
            }
            i++;
        }
    }

    public int[] getNumsArray() {
        return numsArray;
    }
}
