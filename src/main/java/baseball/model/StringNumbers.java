package baseball.model;

import baseball.utils.Validator;
import java.util.List;
import java.util.stream.Collectors;

public class StringNumbers {
    private final String stringNumbers;

    public StringNumbers(String stringNumbers) {
        validateStringNumbers(stringNumbers);
        this.stringNumbers = stringNumbers;
    }

    private void validateStringNumbers(String stringNumbers) {
        Validator.validateStringEmptyOrNull(stringNumbers);
        Validator.validateStringDigit(stringNumbers);
    }

    public List<Integer> translateToIntegerList() {
        return stringNumbers.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}
