package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {
    public static final int NUMBER_LENGTH = 3;
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 9;

//    @Override
//    public List<Integer> generate() {
//        HashSet<Integer> picks = new HashSet<>();
//        while (picks.size() < NUMBER_LENGTH) {
//            picks.add(Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE));
//        }
//        return new ArrayList<>(picks);
//    }

    @Override
    public List<Integer> generate() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
