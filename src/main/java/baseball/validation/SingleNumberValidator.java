package baseball.validation;

import baseball.constant.ErrorMessage;
import baseball.constant.Number;

public class SingleNumberValidator implements Validator {

    public static final String ONLY_NATURE_NUMBER = "^[" + Number.MIN + "-" + Number.MAX + "]+";

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
            throw new IllegalArgumentException(ErrorMessage.ERROR + ErrorMessage.INVALID_TYPE);
        }
    }
}
