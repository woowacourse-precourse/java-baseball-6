package baseball.presenter;

import java.util.HashSet;
import java.util.Set;

public class GamePresenter {
    private boolean isValidNumeric(String numbers) {
        return numbers.matches("^[0-9]+$");
    }

    private boolean isValidLength(String numbers) {
        return numbers.length() == 3;
    }

    private boolean isDuplicate(String numbers) {
        Set<Character> uniqueDigits = new HashSet<Character>();
        for (char element : numbers.toCharArray()) {
            uniqueDigits.add(element);
        }
        return uniqueDigits.size() == 3;
    }
}
