package baseball.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.constant.NumberConstants.MAX_NUMBER;
import static baseball.constant.NumberConstants.MIN_NUMBER;
import static baseball.constant.NumberConstants.NUMBER_SIZE;

public class NumbersValidation implements Validator {
    @Override
    public void validate(String value) {
        validType(value);
        validLength(value);
        validRange(value);
    }

    private void validType(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
    }

    private void validLength(String value) {
        Set<String> tmp = new HashSet<>(Arrays.asList(value.split("")));
        if (tmp.size() != NUMBER_SIZE.getValue() || value.length() != NUMBER_SIZE.getValue()) {
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
    }

    private void validRange(String value) {
        List<Integer> numbers = Arrays.stream(value.split(""))
                .map(Integer::parseInt)
                .toList();
        if (!numbers.stream().allMatch(number -> MIN_NUMBER.getValue() <= number && number <= MAX_NUMBER.getValue())) {
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
    }
}
