package baseball.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        if (tmp.size() != 3 || value.length() != 3) {
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
    }

    private void validRange(String value) {
        List<Integer> numbers = Arrays.stream(value.split(""))
                .map(Integer::parseInt)
                .toList();
        if (!numbers.stream().allMatch(number -> 1 <= number && number <= 9)) {
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
    }
}
