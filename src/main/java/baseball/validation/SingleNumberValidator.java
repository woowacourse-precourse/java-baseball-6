package baseball.validation;

import baseball.constant.ErrorMessage;

public class SingleNumberValidator implements Validator {

    public static final String ONLY_NATURE_NUMBER = "^[1-9]+";

    @Override
    public boolean support(Class<?> clazz) {
        return String.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target) {
        validateType((String) target);
    }

    private void validateType(String target) {
        if (!target.matches(ONLY_NATURE_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TYPE);
        }
    }
}
