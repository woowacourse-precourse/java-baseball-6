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
        if (result.getStrike() == 0 && result.getBall() == 0) {
            System.out.println(Message.NOTHING);
        }
        System.out.println(Message.BALL.of(result.getBall()) + Message.STRIKE.of(result.getStrike()));
    }

    public void printWin() {
        System.out.println(Message.GAME_END);
    }

    public void printAskRestart() {
        System.out.println(Message.ASK_COMMAND);
    }
}
