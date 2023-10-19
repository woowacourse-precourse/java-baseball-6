package baseball.validation;

import java.util.regex.Pattern;

public class InputValidator implements Validation<String> {

    private final static Pattern pattern = Pattern.compile("\\d{3}");

    @Override
    public boolean validation(final String inputValue) {
        if (inputValue == null || inputValue.isEmpty()) {
            return false;
        }
        return pattern.matcher(inputValue).matches();
    }
}
