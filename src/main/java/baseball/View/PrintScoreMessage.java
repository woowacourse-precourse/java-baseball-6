package baseball.View;

import static baseball.dto.GameResult.*;

public class PrintScoreMessage {

    public void PrintMessage(int ball, int strike) {
        if (ball == 0 && strike != 0)
            System.out.println(strike + STRIKE_MESSAGE);    //스트라이크
        if (ball != 0 && strike == 0)
            System.out.println(ball + BALL_MESSAGE);    //볼
        if (ball != 0 && strike != 0)
            System.out.println(ball + BALL_MESSAGE + strike + STRIKE_MESSAGE);  //볼 스트라이크
        if (ball == 0 && strike == 0)
            System.out.println(NO_CONUT_MESSAGE);   //낫싱
    }
    public static void printGameOverMessage() {
        System.out.println(SUCCESS_AND_EXIT_MESSAGE);
    }

}