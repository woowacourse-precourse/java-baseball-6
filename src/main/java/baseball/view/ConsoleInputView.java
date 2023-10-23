package baseball.view;

import static baseball.Constant.END_WANT;
import static baseball.Constant.PLAY_WANT;

import baseball.model.PlayNumber;
import baseball.validator.ResumeValidator;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {

    @Override
    public PlayNumber readPlayNumber() {
        String number = Console.readLine();
        return PlayNumber.from(number);
    }

    @Override
    public int readMoreAnswer() {
        String number = Console.readLine();
        ResumeValidator.assertResumeInput(number, PLAY_WANT.getValue(), END_WANT.getValue());
        return Integer.parseInt(number);
    }
}
