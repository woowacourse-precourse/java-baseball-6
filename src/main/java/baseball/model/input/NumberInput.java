package baseball.model.input;

import static baseball.enums.NumberInputErrorMessage.DUPLICATE_NUMBER;
import static baseball.enums.NumberInputErrorMessage.INVALID_CHARACTER;
import static baseball.enums.NumberInputErrorMessage.INVALID_LENGTH;

import java.util.List;
import java.util.stream.Collectors;

public class NumberInput extends PlayerInput {
    private static final int VALID_INPUT_LENGTH = 3;
    private static final char VALID_MIN_NUM = 1;
    private static final char VALID_MAX_NUM = 9;

    public NumberInput(String input) {
        super(input);
        validate();
    }

    protected void validate() {
        validateInputLength();
        validateAllNumbers();
        validateDuplicateCharacter();
    }

    private void validateInputLength() {
        if (input.length() != VALID_INPUT_LENGTH)
            throw new IllegalArgumentException(INVALID_LENGTH.getMessage());
    }

    private void validateAllNumbers() {
        for (int i = 0; i < VALID_INPUT_LENGTH; i++) {
            int num = Character.getNumericValue(input.charAt(i));
            validateNumber(num);
        }
    }

    private void validateNumber(int num) {
        if ((num < VALID_MIN_NUM) || (num > VALID_MAX_NUM)) {
            throw new IllegalArgumentException(INVALID_CHARACTER.getMessage());
        }
    }

    private void validateDuplicateCharacter() {
        long count = input.chars()
                .distinct()
                .count();

        if (count != VALID_INPUT_LENGTH) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }

    public List<Integer> parseInputToIntegerList() {
        return input.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }
}
