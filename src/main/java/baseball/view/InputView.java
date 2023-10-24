package baseball.view;

import baseball.messages.BaseballGameMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getPlayerNumber(){
        System.out.print(BaseballGameMessage.NUMBER_INPUT_MESSAGE);
        return Console.readLine();
    }
    public String getGameRestartYn(){
        System.out.println(BaseballGameMessage.GAME_RESTART_YN_MESSAGE);
        return Console.readLine();
    }
}
