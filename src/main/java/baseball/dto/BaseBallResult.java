package baseball.dto;

public class BaseBallResult {
	int ballCount, strikeCount;

	public BaseBallResult(int ballCount, int strikeCount) {
		this.ballCount = ballCount;
		this.strikeCount = strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

	public int getStrikeCount() {
		return strikeCount;
	}
}
