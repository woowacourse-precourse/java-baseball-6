package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerBallGenerator {

    private static final int NUMBER_POSITIONS = 10;
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;
    private static final int SELECTION_COUNT = 3;

    // 컴퓨터가 생각하는 임의의 세자리 수 만들어주기
    public static int[] generateComputerBall() {

        int[] computerBall = new int[NUMBER_POSITIONS];
        int index = SELECTION_COUNT;

        // 범위와 갯수를 지정하여 int 배열에 몇번째 위치에 있는지 파악하기
        for (int num : Randoms.pickUniqueNumbersInRange(START_RANGE, END_RANGE, SELECTION_COUNT)) {
            computerBall[num] += index--;
        }

        return computerBall;

    }

}
