package baseball.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    public static void validationCheck(List<Integer> integerInputMessage) {
        if (integerInputMessage == null || integerInputMessage.size() > 3) {
            throw new IllegalArgumentException();
        }
        if (!integerInputMessage.stream().allMatch(numItem -> numItem >= 1 && numItem <= 9)) {
            throw new IllegalArgumentException();
        }
        Set<Integer> uniqueItems = new HashSet<>(integerInputMessage);
        if (uniqueItems.size() != integerInputMessage.size()) {
            throw new IllegalArgumentException();
        }
    }
}
