package baseball.model;

import baseball.util.Constant;

public class Score {
	private final int strike;
	private final int ball;

	public Score(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	public boolean isOnlyStrike() {
		return strike > 0 && ball == 0;
	}

	public boolean isOnlyBall() {
		return strike == 0 && ball > 0;
	}

	public boolean isNothing() {
		return strike == 0 && ball == 0;
	}

	public boolean isGameOver() {
		return strike == Constant.NUMBER_LENGTH;
	}
}
