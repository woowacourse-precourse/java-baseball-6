package baseball;

import baseball.util.Constants;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputNumberValidator {
    private final String validationTarget;

    public InputNumberValidator(String inputNumbers) {
        this.validationTarget = inputNumbers;
        isNullOrEmpty();
        hasThreeDigits();
        hasWrongCharacters();
        hasDuplicatedNumber();
    }

    private void isNullOrEmpty() {
        if (validationTarget == null || validationTarget.length() == 0) {
            throw new IllegalArgumentException(Constants.ERROR_PREFIX_MESSAGE + Constants.EMPTY_INPUT_SUFFIX_MESSAGE);
        }
    }

    private void hasThreeDigits() {
        if (validationTarget.length() != 3) {
            throw new IllegalArgumentException(Constants.ERROR_PREFIX_MESSAGE + Constants.WRONG_LENGTH_SUFFIX_MESSAGE);
        }
    }

    private void hasWrongCharacters() {
        if (!Constants.NUMBER_PATTERN.matcher(validationTarget).matches()) {
            throw new IllegalArgumentException(Constants.ERROR_PREFIX_MESSAGE + Constants.WRONG_CHARACTER_SUFFIX_MESSAGE);
        }
    }

    private void hasDuplicatedNumber() {
        List<Character> convertedCharList = validationTarget.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        if (convertedCharList.size() != convertedCharList.stream().distinct().count()) {
            throw new IllegalArgumentException(Constants.ERROR_PREFIX_MESSAGE + Constants.DUPLICATED_NUMBER_SUFFIX_MESSAGE);
        }
    }
}
