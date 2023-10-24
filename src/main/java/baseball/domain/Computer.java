package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private static final int RANDOM_MIX_NUMBER = 1;
    private static final int RANDOM_MAX_NUMBER = 9;

    public static List<Integer> createRandomNumbers() {
        Set<Integer> randomNumbers = new HashSet<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_MIX_NUMBER, RANDOM_MAX_NUMBER);
            randomNumbers.add(randomNumber);
        }
        return new ArrayList<>(randomNumbers);
    }
}
