package baseball.domain;

public class GameResult {

	private int strikeCount = 0;
	private int ballCount = 0;

	public GameResult() {}

	public void addStrikeCount() {
		strikeCount++;
	}

	public void addBallCount() {
		ballCount++;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

}
