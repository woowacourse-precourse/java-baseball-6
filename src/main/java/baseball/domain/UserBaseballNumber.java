package baseball.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static baseball.handler.ErrorHandler.*;

public class UserBaseballNumber {

    private static final int VALID_VALUES_LENGTH = 3;
    private List<String> userValues;

    public UserBaseballNumber(List<String> userValues) {
        validate(userValues);
        validateDuplicate(userValues);
        validateRange(userValues);

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

    private void validateRange(List<String> userValues) {
        String regex = "^[1-9]+$";

        for (String userValue : userValues) {
            if (!Pattern.matches(regex, userValue)) {
                throw INVALID_RANGE.getException();
            }
        }
    }

    public List<Integer> getUserValues() {
        return userValues.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
