package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Computer {
    public static final int COUNTS = 3;
    public static final int MAXIMUM_NUMBER = 9;
    public static final int MINIMUM_NUMBER = 1;


    private List<Integer> randomNumbers;

    private void generateRandomNumbers() {
        randomNumbers = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        while (set.size() < COUNTS) {
            set.add(Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER));
        }
        randomNumbers.addAll(set);
    }

    public int checkBallCount(List<Integer> userNumbers) {
        return (int) IntStream.range(0, COUNTS)
                .filter(i -> userNumbers.get(i) != randomNumbers.get(i) && randomNumbers.contains(userNumbers.get(i)))
                .count();
    }
}