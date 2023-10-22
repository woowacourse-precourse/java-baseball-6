package baseball.view;

import baseball.domain.Messages;
public class OutputView {
    public void printStartMessage() {
        System.out.println(Messages.START_GAME);
    }

    public void printEndGame() {
        System.out.println(Messages.END_GAME);
    }

    public void printBall(int ball) {
        System.out.println(ball + Messages.BALL);
    }

    public void printStrike(int strike) {
        System.out.println(strike + Messages.STRIKE);
    }

    public void printNoting() {
        System.out.println(Messages.NOTHING);
    }

    public void printInputNum() {
        System.out.println(Messages.INPUT);
    }



}
