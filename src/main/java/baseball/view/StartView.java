package baseball.view;

import baseball.constants.Constants;
import camp.nextstep.edu.missionutils.Console;

public class StartView {
    public void beginMessage(){
        System.out.println(Constants.GAME_START_MESSAGE);
    }
    public String requestUserInput() {
        System.out.print(Constants.USER_INPUT_MESSAGE);
        return Console.readLine();
    }
}
