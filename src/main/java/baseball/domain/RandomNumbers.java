package baseball.domain;

import static baseball.utils.Constants.MAXIMUM_NUMBER;
import static baseball.utils.Constants.MINIMUM_NUMBER;
import static baseball.utils.Constants.TOTAL_BALL_COUNTS;
import static baseball.utils.Constants.VERIFICATION_FAILED;
import static baseball.utils.Constants.VERIFICATION_PASSED;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomNumbers {
    private List<Integer> randomNumbers;

    public RandomNumbers() {
        do {
            this.randomNumbers = generateRandomNumbers();
        } while (!isVerificationPassed());
    }

    private List<Integer> generateRandomNumbers() {
        Set<Integer> set = new HashSet<>();
        while (set.size() < TOTAL_BALL_COUNTS) {
            set.add(Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER));
        }
        List<Integer> list = new ArrayList<>();
        list.addAll(set);
        return list;
    }

    private boolean isVerificationPassed() {
        return validateNumbers(randomNumbers) == VERIFICATION_PASSED;
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
        return numbers.size() == TOTAL_BALL_COUNTS;
    }

    private boolean isWithinRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> number >= MINIMUM_NUMBER && number <= MAXIMUM_NUMBER);
    }

    private boolean hasUniqueValues(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() == TOTAL_BALL_COUNTS;
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }
}
