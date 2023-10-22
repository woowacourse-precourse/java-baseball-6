package baseball.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;

public class RandomNumbersGenerator {

    private static final int COMPUTERNUMBERS_LENGTH = 3;
    private static final int NUMBER_RANGE_START = 1;
    private static final int NUMBER_RANGE_END = 9;

    public ArrayList<Integer> generateNumbers() {
        HashSet<Integer> setcomputernumbers = new HashSet<>();
        while (setcomputernumbers.size() < COMPUTERNUMBERS_LENGTH) {
            int randomnuber = Randoms.pickNumberInRange(NUMBER_RANGE_START, NUMBER_RANGE_END);
            setcomputernumbers.add(randomnuber);
        }
        return new ArrayList<>(setcomputernumbers);
    }

}
