package baseball.util;

import baseball.domain.GameNumberSet;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    public static final int RANGE_MIN = 1;
    public static final int RANGE_MAX = 9;

    public static List<Integer> generate() {
        ArrayList<Integer> computer = new ArrayList<>();
        while (computer.size() < GameNumberSet.NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(RANGE_MIN, RANGE_MAX);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
