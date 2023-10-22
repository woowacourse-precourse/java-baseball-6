package baseball.view;

import static java.util.regex.Pattern.matches;

import baseball.exception.view.InputBlankException;
import baseball.exception.view.InputCanNotChangeToIntException;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {

    private static final String REGEXP_PATTERN_NUMBER = "^[\\d]*$";

    public String readStringCanConvertInt() {
        String guessNumbers = Console.readLine();
        checkIsBlank(guessNumbers);
        checkCanChangeToInteger(guessNumbers);
        return guessNumbers;
    }

    private void checkIsBlank(final String string) {
        if (string.isBlank()) {
            throw new InputBlankException();
        }
    }

    private void checkCanChangeToInteger(final String string) {
        if (!matches(REGEXP_PATTERN_NUMBER, string)) {
            throw new InputCanNotChangeToIntException(string);
        }
    }
}
