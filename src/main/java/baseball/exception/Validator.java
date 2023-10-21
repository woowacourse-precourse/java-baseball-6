package baseball.exception;

import java.util.List;

public class Validator {

    public Validator() {

    }

    public boolean isNumeric(String input) {
        for(char c : input.toCharArray()) {
            if(!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidLength(List<Integer> numbers, int length) {
        return numbers.size() == length;
    }
}
