package baseball.domain;

import baseball.util.Validator;
import baseball.view.InputView;

public class Command {
    private static final String EXIT = "2";
    private static final String RESTART = "1";

    public static String getExit() {
        return EXIT;
    }
    public static String getRestart() {
        return RESTART;
    }

    public static void validate(String input) {
        if(Validator.isInvalid(input)) throw new IllegalArgumentException(Errors.MSG_EXCEPTION_INVALID_INPUT);
    }
}
