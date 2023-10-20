package baseball.domain;

import baseball.view.OutputView;

public class ScoreChecker {
    public void checkScore(OutputView outputView, ScoreCalculator calculator){
        int nothing = calculator.getNothing();
        int ball = calculator.getBall();
        int strike = calculator.getStrike();

        if (nothing == 1) {
            outputView.printNothing();
        }
        if (ball > 0 && strike == 0) {
            outputView.printBall(ball);
            outputView.printBlank();
        }
        if (strike > 0 && ball == 0) {
            outputView.printStrike(strike);
        }
        if (ball > 0 && strike > 0) {
            outputView.printBall(ball);
            outputView.printStrike(strike);
        }
        if (strike == 3) {
            outputView.printGameEnd();
        }
    }
}
