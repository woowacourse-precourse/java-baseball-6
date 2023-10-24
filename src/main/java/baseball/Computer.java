package baseball;

import static baseball.utils.Constants.COUNTS;
import static baseball.utils.Constants.MAXIMUM_NUMBER;
import static baseball.utils.Constants.MINIMUM_NUMBER;
import static baseball.utils.Constants.VERIFICATION_FAILED;
import static baseball.utils.Constants.VERIFICATION_PASSED;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Computer {
    private List<Integer> randomNumbers;

    public Computer() {
    }

    public void init() {
        do {
            generateRandomNumbers();
        } while (!isVerificationPassed());
    }

    private boolean isVerificationPassed() {
        return validateNumbers(randomNumbers) == VERIFICATION_PASSED;
    }


    private void generateRandomNumbers() {
        randomNumbers = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        while (set.size() < COUNTS) {
            set.add(Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER));
        }
        randomNumbers.addAll(set);
    }

    public int checkBallCount(List<Integer> playerNumbers) {
        return (int) IntStream.range(0, COUNTS)
                .filter(i -> playerNumbers.get(i) != randomNumbers.get(i) && randomNumbers.contains(
                        playerNumbers.get(i)))
                .count();
    }

    public int checkStrikeCount(List<Integer> playerNumbers) {
        return (int) IntStream.range(0, COUNTS)
                .filter(i -> playerNumbers.get(i) == randomNumbers.get(i))
                .count();
    }

    private boolean validateNumbers(List<Integer> numbers) {
        if (!isValidSize(numbers)) {
            return VERIFICATION_FAILED;
        }
        if (!isWithinRange(numbers)) {
            return VERIFICATION_FAILED;
        }
        if (!hasUniqueValues(numbers)) {
            return VERIFICATION_FAILED;
        }
        return VERIFICATION_PASSED;
    }

    private boolean isValidSize(List<Integer> numbers) {
        return numbers.size() == COUNTS;
    }

    private boolean isWithinRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> number >= MINIMUM_NUMBER && number <= MAXIMUM_NUMBER);
    }

    private boolean hasUniqueValues(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() == COUNTS;
    }
}