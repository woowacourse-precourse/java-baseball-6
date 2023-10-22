package baseball.domain;

import baseball.view.OutPutView;

public class BallAndStrikeCount {

    private final int strike;
    private final int ball;

    public BallAndStrikeCount(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
        OutPutView.printBallAndStrike(this.strike, this.ball);
    }

    public boolean threeStrike() {
        return this.strike == 3;
    }
}
