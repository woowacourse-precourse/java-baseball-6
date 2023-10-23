package baseball;

import baseball.constant.Message;
import baseball.constant.Number;
import baseball.domain.BaseballCount;
import baseball.util.GameUtil;
import baseball.util.MessageUtil;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        MessageUtil.printStartMsg();
        List<Integer> computer = GameUtil.initRandomNumber();
        while (true) {
            MessageUtil.printInputMsg();
            List<Integer> userNum = GameUtil.inputNumber();
            BaseballCount count = GameUtil.compareBaseball(computer, userNum);
            MessageUtil.printBaseballCount(count);

            if (count.getStrike() == Number.GAME_LENGTH) {
                System.out.println(Message.GAME_FINISH_MSG);
                if (GameUtil.isGameRestart()) {
                    computer = GameUtil.initRandomNumber();
                } else {
                    break;
                }
            }
        }
    }
}
