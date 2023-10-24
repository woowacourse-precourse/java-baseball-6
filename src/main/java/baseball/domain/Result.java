package baseball.domain;

import baseball.presentation.Message;

public class Result {
    Message message = new Message();


    void printResult(int[] result) {
        int strike = result[0];
        int ball = result[1];

        if (strike == 3) {
            message.printStrikeCaseMessage(strike);
        } else {
            if (ball == 0 && strike == 0) {
                message.nothingCaseMessage();
            }
            if (ball > 0 && strike > 0) {
                message.printballStrikeCaseMessage(ball, strike);
            }
            if (ball > 0 && strike == 0) {
                message.printBallCaseMessage(ball);
            }
            if (strike > 0 && ball == 0) {
                message.printStrikeCaseMessage(strike);
            }
        }
    }
}
