package baseball.validation;

import baseball.constant.ApplicationConstant;
import baseball.constant.ExceptionConstant;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidationNumber {
    private static void validationRange(List<Integer> numbers) {
        for (int number : numbers
        ) {
            if (number < ApplicationConstant.MIN_NUMBER || number > ApplicationConstant.MAX_NUMBER) {
                throw new IllegalArgumentException(ExceptionConstant.RANGE_ERROR_MESSAGE);
            }
        }
    }

    private static void validationSize(List<Integer> numbers) {
        if (numbers.size() != ApplicationConstant.NUMBER_SIZE) {
            throw new IllegalArgumentException(ExceptionConstant.SIZE_ERROR_MESSAGE);
        }
    }

    private static void validationDuplicateNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != ApplicationConstant.NUMBER_SIZE) {
            throw new IllegalArgumentException(ExceptionConstant.DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static void validationStatus(int status) {
        if (status < 1 || status > 2) {
            throw new IllegalArgumentException(ExceptionConstant.STATUS_INPUT_ERROR_MESSAGE);
        }
    }

    public static void validateNumbers(List<Integer> numbers) {
        validationSize(numbers);
        validationRange(numbers);
        validationDuplicateNumber(numbers);
    }
}
