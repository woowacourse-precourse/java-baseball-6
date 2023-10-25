package baseball.view;

import baseball.utils.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    Validator validator = new Validator();

    public String getUserGameNumber() {
        String input = Console.readLine();
        validator.validateGetUserGameNumber(input);
        return input;
    }

    public String getUserGameContinue() {
        String input = Console.readLine();
        validator.validateGetUserGameContinue(input);
        return input;
    }
}
