package baseball.Util;

import baseball.constants.Message;
import baseball.dto.Result;

public class MessageUtil {
    public void printStart() {
        System.out.println(Message.GAME_START);
    }

    public void printInput() {
        System.out.print(Message.INPUT);
    }

    public void printResult(Result result) {

    }

    public void printWin() {

    }

    public Integer printAskRestart() {
        return null;
    }
}
