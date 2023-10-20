package baseball;

import static baseball.OutputMessage.*;

class Output {

    static void start() {
        System.out.println(START);
    }

    void askUserNumber() {
        System.out.print(ASK_NUMBER);
    }

    void printResult(JudgeResult result) {
        if (isNothing(result)) {
            System.out.printf(NOTHING);
            return;
        }
        printBallAndStrike(result.getBall(), result.getStrike());
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

    private void printBallAndStrike(int ball, int strike) {
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
