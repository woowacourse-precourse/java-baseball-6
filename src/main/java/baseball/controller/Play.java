package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.Score;
import baseball.model.UserNumber;
import baseball.view.InputView;

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
            if (score.getStrike() == STRIKE_THREE) {
                break;
            }
            score.resetScore();
        }
    }
}
