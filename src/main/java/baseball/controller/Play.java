package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.Score;
import baseball.model.UserNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Play {
    private static final int STRIKE_THREE = 3;
    private final Score score;
    private final UserNumber userNumber;

    public Play(Score score, UserNumber userNumber) {
        this.score = score;
        this.userNumber = userNumber;
    }

    public void play(ComputerNumber computerNumber) {
        while (true) {
            userNumber.newUserNumber(InputView.userNumberInput());
            score.countScore(userNumber.getUserNumber(), computerNumber.getComputerNumber());
            printResult(score);
            if (score.getStrike() == STRIKE_THREE) {
                break;
            }
            score.resetScore();
        }
    }

    private void printResult(Score score) {
        int strike = score.getStrike();
        int ball = score.getBall();

        if (strike == 0 && ball == 0) {
            OutputView.nothing();
            return;
        }

        if (strike == 0) {
            OutputView.onlyBall(ball);
            return;
        }

        if (ball == 0) {
            OutputView.onlyStrike(strike);
            return;
        }

        if (strike > 0 && ball > 0) {
            OutputView.strikeAndBall(strike, ball);
            return;
        }
    }
}
