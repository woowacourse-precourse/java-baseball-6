package baseball.validation;

import baseball.common.GameValue;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberRangeValidator {

    private NumberRangeValidator() {
    }

    public static void validate(List<Integer> numbers) {
        for (Integer number : numbers) {
            checkNumberRange(number);
        }
    }

    public static void validate(String numbers) {
        Pattern pattern = Pattern.compile(RegexPattern.ONE_TO_NINE.getValue());
        Matcher matcher = pattern.matcher(numbers);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE.getMessage());
        }
    }

    private static void checkNumberRange(Integer number) {
        if (number < GameValue.MIN_RANGE.getValue() || number > GameValue.MAX_RANGE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_TYPE.getMessage());
        }
    }
}
