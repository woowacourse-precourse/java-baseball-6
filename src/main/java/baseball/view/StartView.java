package baseball.view;

import baseball.constants.Constants;
import camp.nextstep.edu.missionutils.Console;

public class StartView {
    public static void beginMessage(){
        System.out.println(Constants.GAME_START_MESSAGE);
    }
    public static String requestUserInput(){
        System.out.print(Constants.GAME_START_MESSAGE);
        return Console.readLine();
    }
}
