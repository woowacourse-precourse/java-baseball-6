package baseball.view;

import baseball.validate.InputValidate;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final InputValidate inputValidate;

    public InputView() {
        inputValidate = new InputValidate();
    }

    public String getPlayerGuessNumbers() {
        String givenInput = Console.readLine();
        inputValidate.checkNumbers(givenInput);
        return givenInput;
    }

    public String getPlayerRestart() {
        String givenInput = Console.readLine();
        inputValidate.checkNumber(givenInput);
        return givenInput;
    }
}
