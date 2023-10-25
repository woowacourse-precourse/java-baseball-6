package baseball.logic;

import java.util.List;

import static baseball.constant.Constant.*;

public class InputValidator {

    public List<Integer> validateInput(String inputNumbers) {
        validateLength(inputNumbers);
        List<Integer> numberList = convertStrToList(inputNumbers);
        validateRange(numberList);
        validateDuplicate(numberList);

        return numberList;
    }

    private void validateLength(String inputNumbers) {
        if (inputNumbers.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH_EXCEPTION_MSG);
        }
    }

    private List<Integer> convertStrToList(String inputNumbers) {
        return inputNumbers.chars()
                .map(Character::getNumericValue)
                .boxed()
                .toList();
    }

    private void validateRange(List<Integer> numberList) {
        boolean isRange = numberList.stream()
                .allMatch(number -> number >= INPUT_MIN_VALUE && number <= INPUT_MAX_VALUE);

        if (!isRange) {
            throw new IllegalArgumentException(INVALID_RANGE_EXCEPTION_MSG);
        }
    }

    private void validateDuplicate(List<Integer> numberList) {
        boolean isDuplicate = numberList.stream()
                .distinct()
                .count() != NUMBER_LENGTH;
        if (isDuplicate) {
            throw new IllegalArgumentException(INVALID_DUPLICATE_EXCEPTION_MSG);
        }
    }

    public int validateCommand(String inputNumber) {
        int command = Integer.parseInt(inputNumber);

        if (command != COMMAND_RESTART && command != COMMAND_EXIT) {
            throw new IllegalArgumentException(INVALID_COMMAND_EXCEPTION_MSG);
        }

        return command;
    }
}
