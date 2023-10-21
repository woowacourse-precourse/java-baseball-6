package baseball.validators;

import java.util.HashSet;

public class NoDuplicateValidator implements Validator {
    @Override
    public void validate(String userInput) {
        HashSet<Character> uniqueChars = new HashSet<>();
        for (char ch : userInput.toCharArray()) {
            uniqueChars.add(ch);
        }

        if (uniqueChars.size() != userInput.length()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }
}
