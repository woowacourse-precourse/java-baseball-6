package baseball.domain;

public class GameResult {
	private final int strikeCount;
	private final int ballCount;

	public GameResult(int strikeCount, int ballCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}
}
