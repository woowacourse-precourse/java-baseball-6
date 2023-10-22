package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import static constant.MessageList.*;
public class Input {
    public String getNumberFromPlayer(){
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }
}
