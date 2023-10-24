package baseball.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    private static final int INPUT_NUMBER_CORRECT_LENGTH = 3;
    private static final String INPUT_NUMBER_CORRECT_TYPE = "^[0-9]*$";
    private static final String ZERO_STRING_VALUE = "0";
    private static final String EACH_DIGIT_SPLIT_REGEX = "";
    private static final String ONE_STRING_VALUE = "1";
    private static final String TWO_STRING_VALUE = "2";

    public void validateInputRestartOrEndNumber(String inputRestartOrEndNumber) {//이것도 분리 validator 클래스 하나 더
        if (isInputRestartOrEndNumberNotOneOrTwo(inputRestartOrEndNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInputRestartOrEndNumberNotOneOrTwo(String inputRestartOrEndNumber) {
        return (!inputRestartOrEndNumber.equals(ONE_STRING_VALUE) && !inputRestartOrEndNumber.equals(TWO_STRING_VALUE));
    }

    public void validateInputNumber(String inputNumber) {
        if (isInputNumberNotDigit(inputNumber)) {
            throw new IllegalArgumentException();
        } else if (isInputNumberLengthNotSameThree(inputNumber)) {
            throw new IllegalArgumentException();
        } else if (isInputNumberContainZero(inputNumber)) {
            throw new IllegalArgumentException();
        } else if (isDuplicateInputNumber(inputNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicateInputNumber(String inputNumber) {
        List<String> inputNumberEachDigitList = Arrays.asList(inputNumber.split(EACH_DIGIT_SPLIT_REGEX));
        Set<String> inputNumberEachDigitSet = new HashSet<>(inputNumberEachDigitList);
        return inputNumberEachDigitSet.size() != INPUT_NUMBER_CORRECT_LENGTH;
    }

    private boolean isInputNumberContainZero(String inputNumber) {
        return inputNumber.contains(ZERO_STRING_VALUE);
    }

    private boolean isInputNumberLengthNotSameThree(String inputNumber) {
        return inputNumber.length() != INPUT_NUMBER_CORRECT_LENGTH;
    }

    private boolean isInputNumberNotDigit(String inputNumber) {
        return (!inputNumber.matches(INPUT_NUMBER_CORRECT_TYPE));
    }
}
