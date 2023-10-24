package baseball.io;

import baseball.model.ResultScoreBoard;

public class OutputHandler {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printScore(ResultScoreBoard score) {
        if (score.strike() == 0 && score.ball() == 0) {
            System.out.print("낫싱");
        }
        if (score.ball() != 0) {
            System.out.print(score.ball() + "볼 ");
        }
        if (score.strike() != 0) {
            System.out.print(score.strike() + "스트라이크");
        }
        System.out.println();

    }
}
