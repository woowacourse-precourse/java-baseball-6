package baseball.view;

import baseball.utils.GameOptionValidator;
import baseball.utils.NumberValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputUserNumber() {
        String input = Console.readLine();
        NumberValidator.validateThreeDistinctDigitsInRange(input);
        return input;
    }

    public String inputRestartOption() {
        String input = Console.readLine();
        GameOptionValidator.validateGameRestartOption(input);
        return input;
    }
}
