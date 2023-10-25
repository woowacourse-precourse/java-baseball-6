package baseball.view;

import baseball.constant.GameMessage;
import baseball.model.dto.ResultDto;

public class RefereeView {

    public void printResult(ResultDto resultDto) {
        Integer strike = resultDto.getStrike();
        Integer ball = resultDto.getBall();

        if (strike == 3 && ball == 0) {
            printWinResult();
            return;
        }

        printLostResult(strike, ball);
    }

    public void printWinResult() {
        System.out.println(GameMessage.WIN.getMessage());
    }

    public void printLostResult(Integer strike, Integer ball) {
        if (strike == 0 && ball == 0) {
            System.out.println(GameMessage.NOTHING.getMessage());
        }
        if (strike != 0 && ball == 0) {
            System.out.printf(GameMessage.ONLY_STRIKE_FORMAT.getMessage(), strike);
        }
        if (strike == 0 && ball != 0) {
            System.out.printf(GameMessage.ONLY_BALL_FORMAT.getMessage(), ball);
        }
        if (strike != 0 && ball != 0) {
            System.out.printf(GameMessage.BALL_AND_STRIKE_FORMAT.getMessage(), ball, strike);
        }
    }
}