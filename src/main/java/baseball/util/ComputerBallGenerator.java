package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerBallGenerator {

    public static int[] generateComputerBall() {

        int[] computerBall = new int[10];

        for (int x : Randoms.pickUniqueNumbersInRange(1, 9, 3)) {
            computerBall[x]++;
        }

        return computerBall;

    }

}
