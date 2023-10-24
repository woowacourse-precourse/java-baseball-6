package baseball.view;

import baseball.common.Message;

public class OutputView {
    public void printStart() {
        System.out.println(Message.START.getMessage());
    }

    public void printRestart() {
        System.out.println(Message.END.getMessage());
        System.out.println(Message.RESTART.getMessage());
    }

    public void printGetBall() {
        System.out.print(Message.GET_BALL.getMessage());
    }

    public void printResult(int[] score) {
        System.out.println(Message.getScoreMessage(score[0], score[1]));
    }
}
