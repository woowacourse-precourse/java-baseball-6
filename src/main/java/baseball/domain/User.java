package baseball.domain;

import baseball.exception.DuplicationNumberException;
import baseball.exception.NotNumberException;
import baseball.exception.OverLengthLimitException;
import baseball.exception.UnderLengthLimitException;
import baseball.utils.Range;
import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> input;
    
    public void setInput(String userNumber) {
        input = new ArrayList<>(Range.VALID_INPUT_SIZE.getRange());
        checkValidNumber(userNumber);
        for (char number : userNumber.toCharArray()) {
            input.add(Character.getNumericValue(number));
        }
    }

    public void checkValidNumber(String number) {
        validateType(number);
        validateLength(number.length());
        validateDuplication(number);

    }

    private void validateDuplication(String input) {
        long distinctCount = input.chars()
                .distinct()
                .count();

        if (distinctCount != input.length()) {
            throw new DuplicationNumberException();
        }
    }

    private void validateType(String input) {
        if (!input.chars()
                .allMatch(Character::isDigit)) {
            throw new NotNumberException();
        }
    }

    private void validateLength(int number) {
        if (number < Range.VALID_INPUT_SIZE.getRange()) {
            throw new UnderLengthLimitException();
        } else if (number > Range.VALID_INPUT_SIZE.getRange()) {
            throw new OverLengthLimitException();
        }
    }

    public List<Integer> getInput() {
        return this.input;
    }
}
