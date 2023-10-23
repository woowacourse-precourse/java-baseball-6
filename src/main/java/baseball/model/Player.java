package baseball.model;

import baseball.constant.ExceptionMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Player {

    private static final String REGEX_ONE_TO_NINE = "^[1-9]+$";

    private List<Integer> inputNumbers;

    public void updateNumbers(final String inputNumber) {
        initInputNumbers();
        List<Integer> expectedNumbers = parsingNumber(inputNumber);
        validateOneToNine(expectedNumbers);
        validateDuplicateNumber(expectedNumbers);
        this.inputNumbers = expectedNumbers;
    }

    public List<Integer> getInputNumbers() {
        return Collections.unmodifiableList(inputNumbers);
    }

    private void initInputNumbers() {
        this.inputNumbers = new ArrayList<>();
    }

    private List<Integer> parsingNumber(final String inputNumber) {
        return inputNumber.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }

    private void validateOneToNine(final List<Integer> numbers) {
        for (Integer number : numbers) {
            String numberStr = number.toString();
            boolean isValid = Pattern.matches(REGEX_ONE_TO_NINE, numberStr);

            if (!isValid) {
                String errorMessage = String.format(ExceptionMessage.OUT_OF_NUMBER_RANGE.getMessage(), 1, 9);
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }

    private void validateDuplicateNumber(final List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(ExceptionMessage.HAVE_DUPLICATE_NUMBER.getMessage());
            }
        }
    }
}
