package baseball.model.input;

import java.util.List;
import java.util.stream.Collectors;

public class NumberInput extends PlayerInput {
    private static final int VALID_INPUT_LENGTH = 3;
    private static final char VALID_MIN_NUM = 1;
    private static final char VALID_MAX_NUM = 9;
    private static final String INVALID_LENGTH = "입력이 3자리가 아닙니다.";
    private static final String INVALID_CHARACTER = "숫자가 아닌 문자가 입력되었습니다.";
    private static final String DUPLICATE_NUMBER = "중복된 숫자가 입력되었습니다.";

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
            throw new IllegalArgumentException(INVALID_LENGTH);
    }

    private void validateAllNumbers() {
        for (int i = 0; i < VALID_INPUT_LENGTH; i++) {
            int num = Character.getNumericValue(input.charAt(i));
            validateNumber(num);
        }
    }

    private void validateNumber(int num) {
        if ((num < VALID_MIN_NUM) || (num > VALID_MAX_NUM)) {
            throw new IllegalArgumentException(INVALID_CHARACTER);
        }
    }

    private void validateDuplicateCharacter() {
        long count = input.chars()
                .distinct()
                .count();

        if (count != VALID_INPUT_LENGTH) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER);
        }
    }

    public List<Integer> parseInputToIntegerList() {
        return input.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }
}
