package baseball.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.handler.ErrorHandler.DUPLICATE_NUMBER;
import static baseball.handler.ErrorHandler.INVALID_COUNT;

public class UserBaseballNumber {

    private static final int VALID_VALUES_LENGTH = 3;
    private List<String> userValues;

    public UserBaseballNumber(List<String> userValues) {
        validate(userValues);
        validateDuplicate(userValues);

        this.userValues = userValues;
    }

    private void validate(List<String> userValues) {
        if (userValues.size() != VALID_VALUES_LENGTH) {
            throw INVALID_COUNT.getException();
        }
    }

    private void validateDuplicate(List<String> userValues) {
        Set<String> uniqueValues = new HashSet<>(userValues);

        if (userValues.size() != uniqueValues.size()) {
            throw DUPLICATE_NUMBER.getException();
        }
    }

    public List<String> getUserValues() {
        return List.copyOf(userValues);
    }
}
