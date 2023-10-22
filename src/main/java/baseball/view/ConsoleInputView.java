package baseball.view;

import static java.util.regex.Pattern.matches;

import baseball.exception.view.InputBlankException;
import baseball.exception.view.InputCanNotChangeToIntException;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {

    private static final String REGEXP_PATTERN_NUMBER = "^[\\d]*$";

    private final ConsoleOutputView consoleOutputView;

    public ConsoleInputView(final ConsoleOutputView consoleOutputView) {
        this.consoleOutputView = consoleOutputView;
    }

    public String readGuessNumbers() {
        try {
            String guessNumbers = Console.readLine();
            checkIsBlank(guessNumbers);
            checkCanChangeToInteger(guessNumbers);
            return guessNumbers;
        } catch (IllegalArgumentException exception) {
            consoleOutputView.printExceptionMessage(exception.getMessage());
            return readGuessNumbers();
        }
    }

    public String readGameStateNumber() {
        try {
            String gameState = Console.readLine();
            checkIsBlank(gameState);
            checkCanChangeToInteger(gameState);
            return gameState;
        } catch (IllegalArgumentException exception) {
            consoleOutputView.printExceptionMessage(exception.getMessage());
            return readGameStateNumber();
        }
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
