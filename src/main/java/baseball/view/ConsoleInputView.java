package baseball.view;

import static java.util.regex.Pattern.matches;

import baseball.exception.consoleView.ConsoleInputBlankException;
import baseball.exception.consoleView.ConsoleInputCanNotChangeToIntException;
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
            throw new ConsoleInputBlankException();
        }
    }

    private void checkCanChangeToInteger(final String string) {
        if (!matches(REGEXP_PATTERN_NUMBER, string)) {
            throw new ConsoleInputCanNotChangeToIntException(string);
        }
    }
}
