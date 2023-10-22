package baseball.validation;

import baseball.exception.NumberDuplicateException;
import baseball.view.ErrorMessage;
import java.util.HashSet;
import java.util.Set;

public class NumberDuplicateValidator {

    private NumberDuplicateValidator() {
    }

    public static void validate(String number) {
        Set<Character> characterSet = new HashSet<>();
        for (char c : number.toCharArray()) {
            characterSet.add(c);
        }

        if (characterSet.size() != number.length()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATE.getMessage());
        }
    }
}
