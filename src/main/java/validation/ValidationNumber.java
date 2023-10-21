package validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidationNumber {
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 9;
    private final static String RANGE_ERROR_MESSAGE = "1-9사이의 값을 입력해주세요.";
    private final static String INDEX_ERROR_MESSAGE = "세자리 수를 입력해주세요.";
    private final static String DUPLICATE_ERROR_MESSAGE = "서로 다른 숫자를 입력해주세요.";
    private final static String NUMBER_TYPE_ERROR_MESSAGE = "숫자만 입력해주세요.";

    public static void validationRange(List<Integer> numbers) {
        for (int number : numbers
        ) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
            }
        }
    }

    public static void validationIndex(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException(INDEX_ERROR_MESSAGE);
        }
    }

    public static void validationDuplicateNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != 3) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static int validationNumberType(String number) {
        try {
            return Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(NUMBER_TYPE_ERROR_MESSAGE);
        }
    }

    public static void validateNumbers(List<Integer> numbers) {
        validationIndex(numbers);
        validationRange(numbers);
        validationDuplicateNumber(numbers);
    }
}
