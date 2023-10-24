package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import static baseball.util.Constant.InputView.INPUT_MSG;
import static baseball.util.Constant.InputView.START_MSG;

public class InputView {

    public void start() {
        System.out.println(START_MSG);
    }
    public String getNums() {
        System.out.println(INPUT_MSG);
        return Console.readLine();
    }
}
