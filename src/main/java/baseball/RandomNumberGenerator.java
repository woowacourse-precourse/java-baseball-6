package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUM_DIGIT = 3;

    private static List<Integer> createRandomNumber() {
        List<Integer> number = new ArrayList<Integer>();

        while (number.size() < NUM_DIGIT) {
            int entry = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!number.contains(entry)) {
                number.add(entry);
            }
        }
        return number;
    }

    public static List<Integer> getRandomNumber() {
        return createRandomNumber();
    }
}


