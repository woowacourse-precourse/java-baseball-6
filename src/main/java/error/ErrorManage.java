package error;

import java.util.HashSet;

import static error.ErrorConstant.*;

public class ErrorManage {
    public void inputNumberErrorManage(String input) {
        if (isCorrectLength(input)) {
            throw new IllegalArgumentException(INPUT_LENGTH_ERROR);
        }
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
        if (!hasUniqueDigits(input)) {
            throw new IllegalArgumentException(SAME_NUMBER);
        }
    }

    public void exitNumberErrorManage(String input) {
        if (isCorrectLength(input)) {
            throw new IllegalArgumentException(EXIT_LENGTH_ERROR);
        }
        if (is1or2(input)) {
            throw new IllegalArgumentException(INCORRECT_NUMBER);
        }

    }

    private boolean is1or2(String str) {
        return (!str.equals(CORRECT_NUMBER1) && !str.equals(CORRECT_NUMBER2));
    }

    private boolean isCorrectLength(String str) {
        return (str.length() != 3 && str.length() != 1);
    }

    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    private boolean hasUniqueDigits(String str) {
        HashSet<Character> uniqueDigits = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (uniqueDigits.contains(c)) {
                return false;
            }
            uniqueDigits.add(c);
        }
        return true;
    }
}
