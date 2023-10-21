package baseball.domain;

public class Hint {

	private static final int ZERO = 0;
	private static final int THREE_COUNT = 0;

	private final int strikeCount;
	private final int ballCount;

	public Hint(int strikeCount, int ballCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
	}

	public boolean isStrikeCountZero() {
		return strikeCount == ZERO;
	}

	public boolean isBallCountZero() {
		return ballCount == ZERO;
	}

	public boolean isThreeStrike() {
		return strikeCount == THREE_COUNT;
	}

	public boolean isNothing() {
		return isBallCountZero() && isStrikeCountZero();
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}
}
