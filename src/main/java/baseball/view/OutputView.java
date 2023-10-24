package baseball.view;

import baseball.enums.OutputMessage;

public class OutputView {
    public void printStrike(int strike) {
        System.out.println(strike + OutputMessage.STRIKE.getMsg());
    }

    public void printBall(int ball) {
        System.out.println(ball + OutputMessage.BALL.getMsg());
    }

    public void printStrikeAndBall(int strike, int ball) {
        System.out.println(ball + OutputMessage.BALL.getMsg() + " " + strike + OutputMessage.STRIKE.getMsg());
    }

    public void printNothing() {
        System.out.println(OutputMessage.NOTHING.getMsg());
    }

    public void roundEndMsg() {
        System.out.println(OutputMessage.MATCHING_ALL.getMsg());
    }
}
