package baseball.utils;

import static baseball.constant.MessageConstant.BLANK_EXCEPTION_MSG;
import static baseball.constant.MessageConstant.INPUT_LENGTH_EXCEPTION_MSG;
import static baseball.constant.MessageConstant.INVALID_CHOICE_EXCEPTION_MSG;
import static baseball.constant.MessageConstant.NON_DIGIT_EXCEPTION_MSG;
import static baseball.constant.MessageConstant.NUMBER_DUPLICATE_EXCEPTION_MSG;
import static baseball.constant.MessageConstant.NUMBER_RANGE_EXCEPTION_MSG;
import static baseball.constant.NumberConstant.EXIT_NUM;
import static baseball.constant.NumberConstant.INPUT_LENGTH;
import static baseball.constant.NumberConstant.MAXIMUM_RANGE_NUMBER;
import static baseball.constant.NumberConstant.MINIMUM_RANGE_NUMBER;
import static baseball.constant.NumberConstant.RESTART_NUM;

import java.util.HashSet;
import java.util.List;

public class Validator {

    public List<Integer> validateInputNumber(String input) {
        checkInputForNonBlank(input);
        checkInputOfDigit(input);
        List<Integer> playerNumber = Utils.convertStringToIntList(input);
        checkListLengthThree(playerNumber);
        checkDigitInRange(playerNumber);
        checkDuplicateInList(playerNumber);

        return playerNumber;
    }

    public void checkInputForNonBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(BLANK_EXCEPTION_MSG);
        }
    }

    public void checkInputOfDigit(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(NON_DIGIT_EXCEPTION_MSG);
            }
        }
    }

    public void checkListLengthThree(List<Integer> input) {
        if (input.size() != INPUT_LENGTH) {
            throw new IllegalArgumentException(INPUT_LENGTH_EXCEPTION_MSG);
        }
    }

    public void checkDigitInRange(List<Integer> inputList) {
        for (int number : inputList) {
            if (number < MINIMUM_RANGE_NUMBER || number > MAXIMUM_RANGE_NUMBER) {
                throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION_MSG);
            }
        }
    }

    public void checkDuplicateInList(List<Integer> inputList) {
        HashSet<Integer> uniqueNumbers = new HashSet<>();

        for (Integer number : inputList) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(NUMBER_DUPLICATE_EXCEPTION_MSG);
            }
        }
    }

    public void validateRestartOrExitNumber(String input) {
        checkInputForNonBlank(input);
        int choice = Integer.parseInt(input);

        if (choice != RESTART_NUM && choice != EXIT_NUM) {
            throw new IllegalArgumentException(INVALID_CHOICE_EXCEPTION_MSG);
        }
    }
}
