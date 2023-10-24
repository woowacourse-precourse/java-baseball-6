package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    private static final int RANDOM_MIN_VALUE = 1;
    private static final int RANDOM_MAX_VALUE = 9;
    private static final int RANDOM_NUMBERS_LENGTH = 3;
    private List<Integer> computerNumbers;

    public void setRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < RANDOM_NUMBERS_LENGTH; i++) {
            randomNumbers.add(getRandomNumber(randomNumbers));
        }

        this.computerNumbers = randomNumbers;
    }

    public static int getRandomNumber(List<Integer> randomNumbers) {
        while (true) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE);

            if (isDifferentNumber(randomNumbers, randomNumber)) {
                return randomNumber;
            }
        }
    }

    public static boolean isDifferentNumber(List<Integer> randomNumbers, int randomNumber) {
        return !randomNumbers.contains(randomNumber);
    }
}
