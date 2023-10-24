package baseball.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberValidator {
    private static final int NUMBER_LENGTH = 3;
    private static final int MIN_RANGE_NUM = 1;
    private static final int MAX_RANGE_NUM = 9;
    private final static String WRONG_LENGTH_ERROR_MESSAGE = "세 자리만 입력 가능합니다.";
    private static final String WRONG_RANGE_ERROR_MESSAGE = "1 ~ 9 사이의 숫자만 입력 가능합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "서로 다른 세 자리의 숫자만 입력 가능합니다.";
    private final static String NON_NUMERIC_ERROR_MESSAGE = "숫자로만 이루어진 값을 입력해주세요.";

    public List<Integer> toValidateData(String inputNumber) {
        if (!validateDigit(inputNumber)) {
            throw new IllegalArgumentException(WRONG_LENGTH_ERROR_MESSAGE);
        } else if (!validateRange(inputNumber)) {
            throw new IllegalArgumentException(WRONG_RANGE_ERROR_MESSAGE);
        } else if (!validateDuplicateNumber(inputNumber)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        } else if (!validateNonNumeric(inputNumber)) {
            throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
        }

        return convertStringToIntList(inputNumber);
    }

    private boolean validateDigit(String inputNumber) {
        return inputNumber.length() == NUMBER_LENGTH;
    }

    private boolean validateRange(String inputNumber) {
        String[] numbers = inputNumber.split("");
        for (String number : numbers) {
            if (Integer.parseInt(number) < MIN_RANGE_NUM || Integer.parseInt(number) > MAX_RANGE_NUM) {
                return false;
            }
        }
        return true;
    }

    private boolean validateDuplicateNumber(String inputNumber) {
        String[] numbers = inputNumber.split("");
        Set<String> setNumbers = Arrays.stream(numbers).collect(Collectors.toSet());
        return setNumbers.size() == NUMBER_LENGTH;
    }

    private boolean validateNonNumeric(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public List<Integer> convertStringToIntList(String inputNumber) {
        ArrayList<Integer> transformNumbers = new ArrayList<>();
        for (char number : inputNumber.toCharArray()) {
            transformNumbers.add(Character.getNumericValue(number));
        }
        return transformNumbers;
    }
}
