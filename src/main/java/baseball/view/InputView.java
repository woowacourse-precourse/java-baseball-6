package baseball.view;

import static baseball.model.Message.CORRECT;
import static baseball.model.Message.END;
import static baseball.model.Message.INPUT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputGameNumber() {
        System.out.print(INPUT.getMessage());
        return Console.readLine();
    }

    public String inputReplayNumber() {
        System.out.println(CORRECT.getMessage());
        System.out.println(END.getMessage());
        return Console.readLine();
    }
}
