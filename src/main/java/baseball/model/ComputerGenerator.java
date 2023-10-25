package baseball.model;

import baseball.util.GameConstant;
import camp.nextstep.edu.missionutils.Randoms;

public class ComputerGenerator {
    private static int listSize;
    private static int randomNumber;
    private static boolean checkFlag;
    private static final int UNDER_BOUND = 1;
    private static final int UPPER_BOUND = 9;

    public ComputerGenerator() {
    }

    public static int[] computerList() {
        int[] list = new int[GameConstant.LENGTH];
        listSize = 0;

        while (listSize < GameConstant.LENGTH) {
            randomNumber = Randoms.pickNumberInRange(UNDER_BOUND, UPPER_BOUND);
            checkFlag = false;

            for (int i = 0; i < listSize; i++) {
                if (list[i] == randomNumber) {
                    checkFlag = true;
                    break;
                }
            }
            if (!checkFlag) {
                list[listSize] = randomNumber;
                listSize ++;
            }
        }
        return list;
    }
}
