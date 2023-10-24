package baseball.view;

import baseball.exception.consoleView.ConsoleInputBlankException;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {

    @Override
    public String readLine() {
        String text = Console.readLine();
        checkIsBlank(text);
        return text;
    }

    private void checkIsBlank(final String string) {
        if (string.isBlank()) {
            throw new ConsoleInputBlankException();
        }
    }
}
