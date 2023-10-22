package baseball.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public void checkUserInput(String input) {
        checkLength(input);
        isNumber(input);
        isDuplicated(input);
    }
    public void checkUserFinishInput(String input) {
        if(!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException();
        }
    }

    private void checkLength(String input) {
        if(input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void isNumber(String input) {
        for (char c: input.toCharArray()) {
            if(c < '1' || c > '9') {
                throw new IllegalArgumentException();
            }
        }
    }

    private void isDuplicated(String input) {
        Set<String> inputSet = new HashSet<>(List.of(input.split("")));
        if(input.length() != inputSet.size()) {
            throw new IllegalArgumentException();
        }
    }
}
