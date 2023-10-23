package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerBallGenerator {

    private static final int NUMBER_POSITIONS = 10;
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;
    private static final int SELECTION_COUNT = 3;


    public static int[] generateComputerBall() {

        int[] computerBall = new int[NUMBER_POSITIONS];
        int index = SELECTION_COUNT;

        for (int x : Randoms.pickUniqueNumbersInRange(START_RANGE, END_RANGE, SELECTION_COUNT)) {
            computerBall[x] += index--;
        }

        return computerBall;

    }

}
