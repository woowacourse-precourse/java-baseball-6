package baseball.service;

public class TurnResult {
	private final int ball;
	private final int strike;

	public TurnResult(int ball, int strike) {
		this.ball = ball;
		this.strike = strike;
	}

	public int getBall() {
		return ball;
	}

	public int getStrike() {
		return strike;
	}
}
