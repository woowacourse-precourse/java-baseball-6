package baseball.model;

import baseball.util.Converter;
import java.util.Collections;
import java.util.List;

public class UserNumbers {

    private static final int REQUIRED_NUMBER_COUNT = 3;
    private static final String INVALID_LENGTH_MESSAGE = "숫자는 세 가지를 고를 수 있습니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "중복된 값은 입력할 수 없습니다.";

    private final List<Number> selectedNumbers;

    private UserNumbers(final List<Number> selectedNumbers) {
        this.selectedNumbers = selectedNumbers;
    }

    public static UserNumbers createFromInput(final String input) {
        validateInput(input);
        List<Number> selectedNumbers = Converter.convertStringToNumgerList(input);
        return new UserNumbers(selectedNumbers);
    }

    private static void validateInput(final String input) {
        validateLength(input);
        validateNoDuplicates(input);
    }

    private static void validateLength(final String input) {
        if (input.length() != REQUIRED_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LENGTH_MESSAGE);
        }
    }

    private static void validateNoDuplicates(final String input) {
        if (containsDuplicates(input)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    private static boolean containsDuplicates(final String input) {
        return input.chars()
                .distinct()
                .count() != REQUIRED_NUMBER_COUNT;
    }

    public List<Number> getSelectedNumbers() {
        return Collections.unmodifiableList(selectedNumbers);
    }
}
