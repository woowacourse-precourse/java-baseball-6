package baseball.domain;

import static baseball.utils.ErrorMessage.NUMBERS_DUPLICATED;
import static baseball.utils.ErrorMessage.NUMBERS_NOT_POSITIVE_INTEGER;
import static baseball.utils.ErrorMessage.NUMBERS_OUT_OF_RANGE;
import static baseball.utils.ErrorMessage.NUMBERS_SIZE_IS_INVALID;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Player {
    private List<Integer> numbers;
    private static final int NUMBER_SIZE = 3;
    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 1;

    public Player() {
    }

    public Player(String numberStr) {
        validateSize(numberStr);
        validatePositiveInteger(numberStr);
        validateRange(numberStr);
        validateDuplicatedNumbers(numberStr);
        this.numbers = changeStringToIntegerList(numberStr);
    }

    public void validateSize(String numberStr) {
        if (numberStr.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException(NUMBERS_SIZE_IS_INVALID);
        }
    }

    public void validatePositiveInteger(String numberStr) {
        try {
            Integer.parseUnsignedInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBERS_NOT_POSITIVE_INTEGER);
        }
    }

    public void validateRange(String numberStr) {
        for (Character number : numberStr.toCharArray()) {
            if (number - '0' < MIN_NUMBER || number - '0' > MAX_NUMBER) {
                throw new IllegalArgumentException(NUMBERS_OUT_OF_RANGE);
            }
        }
    }

    public void validateDuplicatedNumbers(String numberStr) {
        Set<String> numberSet = Set.copyOf(Arrays.asList(numberStr.split("")));
        if (numberSet.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(NUMBERS_DUPLICATED);
        }
    }

    public List<Integer> changeStringToIntegerList(String numberStr) {
        return Arrays.asList(numberStr.split(""))
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}