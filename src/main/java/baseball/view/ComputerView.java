package baseball.view;

import baseball.constant.GameConstant;
import baseball.constant.GameMessage;
import java.util.List;

public class ComputerView {

    public void printGameStart() {
        System.out.println(GameMessage.START.getMessage());
    }

    public void printWinResult() {
        System.out.println(GameMessage.WIN.getMessage());
    }

    public void printLostResult(List<Integer> strikeAndBall) {
        Integer strike = strikeAndBall.get(GameConstant.STRIKE_INDEX);
        Integer ball = strikeAndBall.get(GameConstant.BALL_INDEX);

        if (strike == 0 && ball == 0) {
            System.out.println(GameMessage.NOTHING.getMessage());
        } else if (strike != 0 && ball == 0) {
            System.out.printf(GameMessage.ONLY_STRIKE_FORMAT.getMessage(), strike);
        } else if (strike == 0 && ball != 0) {
            System.out.printf(GameMessage.ONLY_BALL_FORMAT.getMessage(), ball);
        } else {
            System.out.printf(GameMessage.BALL_AND_STRIKE_FORMAT.getMessage(), ball, strike);
        }
    }
}