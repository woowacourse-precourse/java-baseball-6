package baseball.io.input.validation;

import java.util.regex.Pattern;

import baseball.io.input.validation.Validation;

public class InputValidator implements Validation<String> {

    private final static Pattern pattern = Pattern.compile("^(?!.*(\\d)(?:\\d*?\\1)+)(?!.*0)\\d{3}$");

    @Override
    public boolean validation(final String inputValue) {
        final boolean isNotNullAndEmpty = inputValue != null && !inputValue.isEmpty();
        if (!isNotNullAndEmpty) {
            return false;
        }
        return pattern.matcher(inputValue).matches();
    }
}
