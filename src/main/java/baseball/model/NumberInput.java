package baseball.model;

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
            throw new IllegalArgumentException();
    }

    private void checkCharacter(char ch) {
        if ((ch < VALID_MIN_CHAR) || (ch > VALID_MAX_CHAR)) {
            throw new IllegalArgumentException();
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
            throw new IllegalArgumentException();
        }
    }
}
