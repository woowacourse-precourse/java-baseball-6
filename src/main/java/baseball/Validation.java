package baseball;

import java.util.HashSet;
import java.util.Set;

public class Validation {
    public void validationNumber(String answer) {
        if (answer.length() != 3) {
            throw new IllegalArgumentException();
        }

        Set<Character> charSet = new HashSet<>();
        for (char c : answer.toCharArray()) {
            if (!charSet.add(c)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
