package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import static baseball.message.ResultMessage.*;

public class InputView {

    public String inputNumber() {
        System.out.print(INPUT_NUMBER.getMessage());
        return Console.readLine();
    }

    public String inputRestartNum() {
        return Console.readLine();
    }
}
