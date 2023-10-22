package baseball.view;

import baseball.util.MessageConst;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputPlayerNumber() {
        System.out.print(MessageConst.INPUT_MSG);
        return Console.readLine();
    }
}
