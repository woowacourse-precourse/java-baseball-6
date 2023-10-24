package baseball.Model;

import static baseball.Model.Computer.computerNum;
import static baseball.View.OutputView.printBallAndStrike;
import static baseball.View.OutputView.printGameOver;
import static baseball.View.OutputView.printNothing;

public class Count {
    public static int ball = 0;
    public static int strike = 0;

    public void checkBallAndStrike(int numIndex, int userNumIndex) {
        if (!checkBall(userNumIndex)) {
            return;
        }
        if (checkStrike(numIndex, userNumIndex)) {
            addStrike();
            return;
        }
        addBall();

    }

    private boolean checkBall(int userNumIndex) {
        return computerNum.contains(userNumIndex);
    }

    private boolean checkStrike(int numIndex, int userNumIndex) {
        return computerNum.get(numIndex) == userNumIndex;
    }

    private void addBall() {
        ball++;
    }

    private void addStrike() {
        strike++;
    }

    public void resetBall() {
        ball = 0;
    }

    public void resetStrike() {
        strike = 0;
    }

    public boolean countingBall(int strike, int ball) {
        if (strike == 3) {
            printGameOver();
            return true;
        }
        if (strike == 0 && ball == 0) {
            printNothing();
        }
        if (strike != 0 || ball != 0) {
            printBallAndStrike(strike, ball);
        }
        return false;
    }
}
