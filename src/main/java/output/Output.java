package output;

import static output.OutputMessage.ASK_NUMBER;
import static output.OutputMessage.BALL;
import static output.OutputMessage.BALL_AND_STRIKE;
import static output.OutputMessage.CORRECT_AND_ASK_RESTART;
import static output.OutputMessage.NOTHING;
import static output.OutputMessage.START;
import static output.OutputMessage.STRIKE;

import judge.JudgeResult;
import judge.JudgeStatus;

public class Output {

    public void start() {
        System.out.println(START);
    }

    public void askUserNumber() {
        System.out.print(ASK_NUMBER);
    }

    public void printResult(JudgeResult result) {
        if (isNothing(result)) {
            System.out.printf(NOTHING);
            return;
        }
        printBallAndStrike(result);
        if (isCorrect(result)) {
            System.out.printf(CORRECT_AND_ASK_RESTART);
        }
    }

    private boolean isNothing(JudgeResult result) {
        return result.getStatus() == JudgeStatus.NOTHING;
    }

    private boolean isCorrect(JudgeResult result) {
        return result.getStatus() == JudgeStatus.CORRECT;
    }

    private void printBallAndStrike(JudgeResult result) {
        int ball = result.getBall();
        int strike = result.getStrike();

        if (ball != 0 && strike == 0) {
            System.out.printf(BALL, ball);
        }
        if (ball == 0 && strike != 0) {
            System.out.printf(STRIKE, strike);
        }
        if (ball != 0 && strike != 0) {
            System.out.printf(BALL_AND_STRIKE, ball, strike);
        }
    }
}
