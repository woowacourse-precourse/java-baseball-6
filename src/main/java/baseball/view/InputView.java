package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final OutputView output = new OutputView();
    public String inputNumber() {
        output.inputNumberMessage();
        return Console.readLine();
    }

    public String resetOrEnd() {
        output.contiOrEndMessage();
        return Console.readLine();
    }
}
