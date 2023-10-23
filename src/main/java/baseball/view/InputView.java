package baseball.view;

import static baseball.model.Constant.CORRECT;
import static baseball.model.Constant.END;
import static baseball.model.Constant.INPUT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputGameNumber() {
        System.out.print(INPUT);
        return Console.readLine();
    }

    public String inputReplayNumber() {
        System.out.println(CORRECT);
        System.out.println(END);
        return Console.readLine();
    }
}
