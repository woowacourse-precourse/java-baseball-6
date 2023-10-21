package baseball.utils;

import java.util.HashSet;

public class ValidationUtil {
    HashSet<Character> charSet = new HashSet<>();

    public void validate(String userInput) throws IllegalArgumentException {
        charSet.clear();

        checkLength(userInput);
        for (int i = 0; i < userInput.length(); i++) {
            checkRange(userInput.charAt(i));
            checkDuplicate(userInput.charAt(i));
        }
    }

    private void checkLength(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void checkRange(char ch) {
        if (ch < '0' || ch  > '9') {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicate(char ch) {
        if (charSet.contains(ch)) {
            throw new IllegalArgumentException();
        }
        charSet.add(ch);
    }
}
