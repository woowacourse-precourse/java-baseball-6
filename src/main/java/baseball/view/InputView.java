package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public final class InputView {
    public String readNumbers() {
        String input = readLine();
        InputValidator.validateIsNumeric(input);
        return input;
    }

    public String readEndNumber() {
        String input = readLine();
        return input;
    }
}
