package baseball.validation;

import baseball.view.ErrorMessage;
import baseball.view.GameValue;
import baseball.view.RegexPattern;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberFormatValidator {

    private NumberFormatValidator() {
    }

    public static void validate(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < GameValue.MIN_RANGE.getValue() || number > GameValue.MAX_RANGE.getValue()) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_TYPE.getMessage());
            }
        }
    }

    public static void validate(String numbers) {
        Pattern pattern = Pattern.compile(RegexPattern.ONLY_NUMBER.getValue());
        Matcher matcher = pattern.matcher(numbers);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_TYPE.getMessage());
        }
    }
}
