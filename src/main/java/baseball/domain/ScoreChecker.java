package baseball.domain;

import baseball.constants.BaseballConstant;
import baseball.view.OutputView;

public class ScoreChecker {
    public void checkScore(OutputView outputView, ScoreCalculator calculator){
        int nothing = calculator.getNothing();
        int ball = calculator.getBall();
        int strike = calculator.getStrike();

        if (nothing == BaseballConstant.ONE_SCORE) {
            outputView.printNothing();
        }
        if (ball > BaseballConstant.ZERO_SCORE && strike == BaseballConstant.ZERO_SCORE) {
            outputView.printBall(ball);
            outputView.printBlank();
        }
        if (strike > BaseballConstant.ZERO_SCORE && ball == BaseballConstant.ZERO_SCORE) {
            outputView.printStrike(strike);
        }
        if (ball > BaseballConstant.ZERO_SCORE && strike > BaseballConstant.ZERO_SCORE) {
            outputView.printBall(ball);
            outputView.printStrike(strike);
        }
        if (strike == BaseballConstant.THREE_STRIKE) {
            outputView.printGameEnd();
        }
    }
}
