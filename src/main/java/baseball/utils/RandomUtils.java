package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {

    public int[] getGameNumber() {
        int[] gameNumber = new int[3];
        for (int i = 0; i < gameNumber.length; i++) {
            gameNumber[i] = Randoms.pickNumberInRange(1, 9);
        }

        return gameNumber;
    }
}