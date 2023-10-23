package baseball.view;

import baseball.enums.OutputMessage;
import baseball.model.GameScore;
import java.util.List;

public class OutputView {

    public void printResult(GameScore score) {
        List<Integer> result = score.getResult();
        int strike = result.get(0);
        int ball = result.get(1);

        if (strike > 0 && ball == 0) {
            printStrike(strike);
        } else if (strike == 0 && ball > 0) {
            printBall(ball);
        } else if (strike > 0 && ball > 0) {
            printStrikeAndBall(strike, ball);
        } else if (strike == 0 && ball == 0) {
            printNothing();
        }
    }

    private void printStrike(int strike) {
        System.out.println(strike + OutputMessage.STRIKE.getMsg());
    }

    private void printBall(int ball) {
        System.out.println(ball + OutputMessage.BALL.getMsg());
    }

    private void printStrikeAndBall(int strike, int ball) {
        System.out.println(ball + OutputMessage.BALL.getMsg() + " " + strike + OutputMessage.STRIKE.getMsg());
    }

    private void printNothing() {
        System.out.println(OutputMessage.NOTHING.getMsg());
    }

    public void roundEndMsg() {
        System.out.println(OutputMessage.MATCHING_ALL.getMsg());
    }
}
