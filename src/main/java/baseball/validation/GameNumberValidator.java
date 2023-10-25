package baseball.validation;

import baseball.constant.ErrorMessage;
import baseball.constant.Number;

import java.util.List;
import java.util.Set;

public class GameNumberValidator implements Validator {

    @Override
    public boolean support(Class<?> clazz) {
        return List.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target) {
        validateDuplicate((List<?>) target);
        validateSize((List<?>) target);
    }

    private void validateSize(List<?> target) {
        if (!Number.SIZE.equals(target.size())) {
            throw new IllegalArgumentException(ErrorMessage.ERROR + ErrorMessage.INVALID_SIZE);
        }
    }

    private void validateDuplicate(List<?> target) {
        if (target.size() != Set.copyOf(target).size()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR + ErrorMessage.DUPLICATE_NUMBER);
        }
    }
}
