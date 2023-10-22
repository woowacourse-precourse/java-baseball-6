package baseball.view;

import baseball.utils.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    Validator validator = new Validator();

    public String getUserGameNumber() {
        String input = Console.readLine();
        validator.validateNumeric(input);
        validator.validateUnderOne(input);
        validator.validateNumberLengthThree(input);
        validator.validateNumberDuplication(input);
        return input;
    }
}
