package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Opponent {
    private static final int MAXIMUM_NUMBER = 9;
    private static final int MINIMUM_NUMBER = 1;

    private final int targetLength;
    private final boolean[] isTargetNumber;
    private final List<Integer> targetNumbers;

    public Opponent(int targetLength) {
        this.targetLength = targetLength;
        this.targetNumbers = generateTarget();
        this.isTargetNumber = new boolean[MAXIMUM_NUMBER + 1];

        targetNumbers.forEach(number -> isTargetNumber[number] = true);
    }

    public GuessResult guess(List<Integer> guessNumbers) {
        validate(guessNumbers);

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < targetLength; i++) {
            int guessNumber = guessNumbers.get(i);
            int targetNumber = targetNumbers.get(i);

            if (guessNumber == targetNumber) {
                strike++;
            } else if (isTargetNumber[guessNumber]) {
                ball++;
            }
        }

        return new GuessResult(ball, strike);
    }

    private List<Integer> generateTarget() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER, targetLength);
    }

    private void validate(List<Integer> guessNumbers) {
        boolean isValid = guessNumbers.size() == targetLength;

        long uniqueNumberCount = guessNumbers.stream()
                .distinct()
                .count();

        isValid &= uniqueNumberCount == targetLength;
        isValid &= guessNumbers.stream()
                .allMatch(this::isNumberInRange);

        if (!isValid) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNumberInRange(int number) {
        return MINIMUM_NUMBER <= number && number <= MAXIMUM_NUMBER;
    }
}
