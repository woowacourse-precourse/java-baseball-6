package baseball.logic;

import static baseball.constant.Constant.COMMAND_EXIT;
import static baseball.constant.Constant.COMMAND_RESTART;
import static baseball.constant.Constant.INPUT_MAX_VALUE;
import static baseball.constant.Constant.INPUT_MIN_VALUE;
import static baseball.constant.Constant.INVALID_COMMAND_EXCEPTION_MSG;
import static baseball.constant.Constant.INVALID_DUPLICATE_EXCEPTION_MSG;
import static baseball.constant.Constant.INVALID_LENGTH_EXCEPTION_MSG;
import static baseball.constant.Constant.INVALID_RANGE_EXCEPTION_MSG;
import static baseball.constant.Constant.NUMBER_LENGTH;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    public List<Integer> validateInput(String inputNumbers) {
        validateLength(inputNumbers);
        List<Integer> numberList = convertStrToList(inputNumbers);
        validateRange(numberList);
        validateDuplicate(numberList);

        return numberList;
    }

    public void validateLength(String inputNumbers) {
        if (inputNumbers.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH_EXCEPTION_MSG);
        }
    }

    public List<Integer> convertStrToList(String inputNumbers) {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            numberList.add((int) inputNumbers.charAt(i) - '0');
        }
        return numberList;
    }

    public void validateRange(List<Integer> numberList) {
        boolean isRange = true;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            int number = numberList.get(i);
            if (number < INPUT_MIN_VALUE || number > INPUT_MAX_VALUE) {
                isRange = false;
                break;
            }
        }
        if (!isRange) {
            throw new IllegalArgumentException(INVALID_RANGE_EXCEPTION_MSG);
        }
    }

    public void validateDuplicate(List<Integer> numberList) {
        boolean isDuplicate = false;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            for (int j = 0; j < i; j++) {
                if (numberList.get(i).equals(numberList.get(j))) {
                    isDuplicate = true;
                    break;
                }
            }
        }
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
