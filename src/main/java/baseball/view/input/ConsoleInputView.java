package baseball.view.input;

import baseball.model.number.PlayNumber;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {

    @Override
    public PlayNumber readPlayNumber() {
        String number = Console.readLine();
        return PlayNumber.from(number);
    }

    @Override
    public String readMorePlayAnswer() {
        String answer = Console.readLine();
        return answer;
    }
}
