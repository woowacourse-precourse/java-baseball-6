package baseball.view;

import baseball.resources.GameMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputUserNumber() {
        System.out.print(GameMessage.INPUT_NUMBER);
        return Console.readLine();
    }

    public Integer askRestart() {
        System.out.println(GameMessage.ASK_RESTART);
        return Integer.parseInt(Console.readLine());
    }
}
