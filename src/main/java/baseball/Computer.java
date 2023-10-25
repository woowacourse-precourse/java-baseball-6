package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static final int NUMBER_DIGITS = 3;
    public static final int MAX_NUMBER = 9;
    public static final int MIN_NUMBER = 1;
    private static final boolean VALID_SUCCESS = true;
    private static final boolean VALID_FAILED = false;
    private List<Integer> randomNumbers;

    public Computer() {
    }

    public void init() {
        do {
            generateNewRandomNumbers();
        } while (validateNumbers(randomNumbers) == VALID_FAILED);
    }

    private void generateNewRandomNumbers() {
        randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < NUMBER_DIGITS) {
            int number = pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!randomNumbers.contains(number)) {
                randomNumbers.add(number);
            }
        }
    }

    private boolean validateNumbers(List<Integer> numbers) {
        if (numbers.size() != NUMBER_DIGITS) {
            return VALID_FAILED;
        }
        for (int i = 0; i < NUMBER_DIGITS; i++) {
            if (numbers.get(i) < MIN_NUMBER || MAX_NUMBER < numbers.get(i)) {
                return VALID_FAILED;
            }
        }
        if (numbers.stream().distinct().count() != NUMBER_DIGITS) {
            return VALID_FAILED;
        }
        return VALID_SUCCESS;
    }

    public int checkBallCount(List<Integer> userNumbers) {
        int ballCount = 0;
        for (int i = 0; i < NUMBER_DIGITS; i++) {
            int userNumber = userNumbers.get(i);
            if (randomNumbers.contains(userNumber)
                    && userNumber != randomNumbers.get(i)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public int checkStrikeCount(List<Integer> userNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < NUMBER_DIGITS; i++) {
            int userNumber = userNumbers.get(i);
            if (userNumber == randomNumbers.get(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
}