package baseball.model;

public class InputEndChoice {
    private static final int RESTART = 1;
    private static final int QUIT = 2;
    private static final int INPUT_CHOICE_LENGTH = 1;

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
