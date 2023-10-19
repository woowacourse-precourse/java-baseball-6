package baseball.view;

import baseball.messages.BaseballGameMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getPlayerNumber(){
        System.out.print(BaseballGameMessage.NUMBER_INPUT_MESSAGE);
        return Console.readLine();
    }
}
