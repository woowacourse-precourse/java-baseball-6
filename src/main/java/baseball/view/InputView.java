package baseball.view;

import static baseball.Constant.END_WANT;
import static baseball.Constant.PLAY_NUMBER_DIGIT;
import static baseball.Constant.PLAY_WANT;

import baseball.validator.NumberValidator;
import baseball.validator.ResumeValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public InputView() {
    }

    public int readPlayNumber() {
        String number = Console.readLine();
        NumberValidator.assertInputNumberWithLength(number, PLAY_NUMBER_DIGIT.getValue());
        return Integer.parseInt(number);
    }

    public int readMoreAnswer() {
        String number = Console.readLine();
        ResumeValidator.assertResumeInput(number, PLAY_WANT.getValue(), END_WANT.getValue());
        return Integer.parseInt(number);
    }
}
