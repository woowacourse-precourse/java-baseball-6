package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    public int getRandomNumber() {
        int result = 0;

        for (int i = 2; i >= 0; i--) {
            result = result + Randoms.pickNumberInRange(1, 9) * (int) Math.pow(10, i);
        }

        return result;
    }
}
