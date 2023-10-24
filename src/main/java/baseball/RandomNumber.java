package baseball;

import java.util.HashSet;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    int[] target = new int[3];

    private void getRandomNumber() {
        HashSet<Integer> set = new HashSet<>();
        int idx = 0;

        while (idx < 3) {
            int chk = Randoms.pickNumberInRange(1, 9);
            if (!set.contains(chk)) {
                target[idx] = chk;
                set.add(chk);
                idx++;
            }
        }
    }

    public int[] pickRandom() {
        getRandomNumber();
        return target;
    }
}
