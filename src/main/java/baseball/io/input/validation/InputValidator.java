package baseball.io.input.validation;

import java.util.regex.Pattern;

public class InputValidator implements Validation<String> {

    private static InputValidator instance;
    private final Pattern pattern;

    private InputValidator() {
        this.pattern = Pattern.compile("^(?!.*(\\d)(?:\\d*?\\1)+)(?!.*0)\\d{3}$");
    }

    public static InputValidator singleton() {
        if (instance == null) {
            instance = new InputValidator();
        }
        return instance;
    }

    @Override
    public boolean validation(final String inputValue) {
        final boolean isNotNullAndEmpty = inputValue != null && !inputValue.isEmpty();
        if (!isNotNullAndEmpty) {
            return false;
        }
        return pattern.matcher(inputValue).matches();
    }
}
