package baseball.model;

import static baseball.model.Constants.INPUT_CHOICE_LENGTH;
import static baseball.model.Constants.QUIT;
import static baseball.model.Constants.RESTART;

public class InputEndChoice {


    public enum Choice {
        RESTART, QUIT
    }

    public Choice checkInputChoice(String input) {
        checkSize(input);
        return (checkValidNumber(input));
    }

    private void checkSize(String input) {
        if (input.length() != INPUT_CHOICE_LENGTH) {
            throw new IllegalArgumentException("1,2 만 입력 가능");
        }
    }

    private Choice checkValidNumber(String input) {
        char tmpNumber = input.charAt(0);
        if (Character.getNumericValue(tmpNumber) == RESTART) {
            return Choice.RESTART;
        }
        if (Character.getNumericValue(tmpNumber) == QUIT) {
            return Choice.QUIT;
        }
        throw new IllegalArgumentException("1,2만 입력 가능");
    }
}
