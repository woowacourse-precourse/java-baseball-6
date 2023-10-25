package baseball.view;

import baseball.validation.NumberValidation;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int enterNumber(NumberValidation validation) {
        String userInput = Console.readLine();
        validation.validateAll(userInput);

        return Integer.parseInt(userInput);
    }

    public int enterRestartOrEnd(NumberValidation validation) {
        String userInput = Console.readLine();
        validation.validateGap(userInput);
        validation.validateRestartOrEnd(userInput);

        return Integer.parseInt(userInput);
    }
}
