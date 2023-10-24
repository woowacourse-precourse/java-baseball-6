package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GameNumbers {

    private static final int LOWER_BOUND = 1;

    private static final int UPPER_BOUND = 9;

    private static final int LENGTH = 3;

    private final List<Integer> numbers;

    private GameNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static GameNumbers create() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() != LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(LOWER_BOUND, UPPER_BOUND);
            addNonDuplicateRandomNumber(numbers, randomNumber);
        }
        return new GameNumbers(numbers);
    }

    private static void addNonDuplicateRandomNumber(List<Integer> numbers, final int randomNumber) {
        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber);
        }
    }

    public static GameNumbers getInstance(final List<Integer> numbers) {
        validate(numbers);
        return new GameNumbers(numbers);
    }

    public static void validate(List<Integer> gameNumbersOfPlayer) {
        validateLength(gameNumbersOfPlayer.size());
        checkForDuplicateNumbers(gameNumbersOfPlayer);
        for (int i = 0; i < LENGTH; i++) {
            validateRange(gameNumbersOfPlayer.get(i));
        }
    }

    private static void checkForDuplicateNumbers(List<Integer> gameNumbersOfPlayer) {
        boolean isDuplicated = new HashSet<>(gameNumbersOfPlayer)
                .size() < gameNumbersOfPlayer.size();
        if (isDuplicated) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateLength(final int lengthOfUserInput) {
        if (lengthOfUserInput != LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateRange(final int number) {
        if (number > UPPER_BOUND || number < LOWER_BOUND) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isSameValueAt(final int index, final int comparedValue) {
        return numbers.get(index) == comparedValue;
    }

    public boolean isContains(final int value) {
        return numbers.contains(value);
    }

    public int valueAt(final int index) {
        return numbers.get(index);
    }

}
