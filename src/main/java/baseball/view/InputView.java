package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import static baseball.message.Message.*;

public class InputView {

    public String inputNumber() {
        System.out.print(INPUT_NUMBER.getMessage());
        return Console.readLine();
    }

    public String inputRestartNum() {
        return Console.readLine();
    }
}
