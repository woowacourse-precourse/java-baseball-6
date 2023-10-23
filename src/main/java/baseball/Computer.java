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
    private static final boolean VERIFICATION_PASSED = true;
    private static final boolean VERIFICATION_FAILED = false;

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

    public int checkStrikeCount(List<Integer> userNumbers) {
        return (int) IntStream.range(0, COUNTS)
                .filter(i -> userNumbers.get(i) == randomNumbers.get(i))
                .count();
    }

    private boolean validateNumbers(List<Integer> numbers) {
        for (int i = 0; i < COUNTS; i++) {
            if (numbers.get(i) < MINIMUM_NUMBER || numbers.get(i) > MAXIMUM_NUMBER) {
                return VERIFICATION_FAILED;
            }
        }
        if (numbers.size() != COUNTS) {
            return VERIFICATION_FAILED;
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != COUNTS) {
            return VERIFICATION_FAILED;
        }
        return VERIFICATION_PASSED;
    }
}