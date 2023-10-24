package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import static constant.MessageList.GAME_RESTART_OR_END_MESSAGE;
import static constant.MessageList.INPUT_MESSAGE;

public class InputView {
    public static String getNumberFromPlayer(){
        System.out.print(INPUT_MESSAGE);
        return Console.readLine();
    }
    public static String restartGameOrNot(){
        System.out.println(GAME_RESTART_OR_END_MESSAGE);
        return Console.readLine();
    }
}
