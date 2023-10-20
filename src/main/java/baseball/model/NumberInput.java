package baseball.model;

import static baseball.model.enums.NumberInputErrorMessage.DUPLICATE_NUMBER;
import static baseball.model.enums.NumberInputErrorMessage.INVALID_CHARACTER;
import static baseball.model.enums.NumberInputErrorMessage.INVALID_LENGTH;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberInput extends PlayerInput {
    private static final int VALID_INPUT_LENGTH = 3;
    private static final char VALID_MIN_CHAR = '1';
    private static final char VALID_MAX_CHAR = '9';

    public NumberInput(String input) {
        super(input);
        validate();
    }

    protected void validate() {
        checkInputLength();
        checkAllCharacter();
        checkDuplicateChar();
    }

    private void checkInputLength() {
        if (input.length() != VALID_INPUT_LENGTH)
            throw new IllegalArgumentException(INVALID_LENGTH.getMessage());
    }

    private void checkCharacter(char ch) {
        if ((ch < VALID_MIN_CHAR) || (ch > VALID_MAX_CHAR)) {
            throw new IllegalArgumentException(INVALID_CHARACTER.getMessage());
        }
    }

    private void checkAllCharacter() {
        for (int i = 0; i < VALID_INPUT_LENGTH; i++) {
            checkCharacter(input.charAt(i));
        }
    }

    private void checkDuplicateChar() {
        String[] split = input.split("");
        Set<String> set = new HashSet<>(List.of(split));
        if (set.size() != VALID_INPUT_LENGTH) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }

    public List<Integer> parseInputToIntegerList() {
        List<Integer> list = new ArrayList<>(3);
        String[] split = input.split("");
        for (int i = 0; i < VALID_INPUT_LENGTH; i++) {
            Integer num = Integer.parseInt(split[i]);
            list.add(num);
        }
        return list;
    }
}
