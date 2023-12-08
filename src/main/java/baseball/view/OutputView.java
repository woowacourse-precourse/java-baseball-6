package baseball.view;

import baseball.dto.CompareResult;

public class OutputView {

    public void printStartMessage() {
        System.out.println(BaseballMessages.START_MESSAGE);
    }

    public void printCompareResult(CompareResult compareResult) {
        int ball = compareResult.ball();
        int strike = compareResult.strike();
        if (strike == 0 && ball == 0) {
            System.out.println(BaseballMessages.NOTHING);
            return;
        }

        StringBuilder message = new StringBuilder();
        if (ball != 0) {
            message.append(ball).append(BaseballMessages.BALL)
                    .append(" ");
        }
        if (strike != 0) {
            message.append(strike).append(BaseballMessages.STRIKE);
        }

        System.out.println(message);
    }
}
