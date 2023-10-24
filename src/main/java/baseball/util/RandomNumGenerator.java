package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public final class RandomNumGenerator {
    static int pickSize = 3;
    static int minRange = 1;
    static int maxRange = 9;
    public static List<Integer> generate() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < pickSize) {
            int randomNumber = Randoms.pickNumberInRange(minRange, maxRange);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
