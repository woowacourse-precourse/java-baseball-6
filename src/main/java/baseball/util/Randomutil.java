package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedList;

public class Randomutil {

    public static LinkedList<Integer> CreateRandomNum() {
        LinkedList<Integer> randomNumComputer = new LinkedList<>();
        while (randomNumComputer.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!randomNumComputer.contains(randomNum)) {
                randomNumComputer.add(randomNum);
            }
        }
        return randomNumComputer;
    }
}
