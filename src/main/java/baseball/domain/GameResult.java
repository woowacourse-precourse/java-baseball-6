package baseball.domain;

public class GameResult {

	private static final int END_CONDITION = 3;

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

	public boolean isNothing() {
		return this.ballCount == 0 && this.strikeCount == 0;
	}

	public boolean isEnded() {
		return this.strikeCount == END_CONDITION && this.ballCount == 0;
	}

	public boolean existOnlyBall() {
		return this.ballCount != 0 && this.strikeCount == 0;
	}

	public boolean existOnlyStrike() {
		return this.strikeCount != 0 && this.ballCount == 0;
	}

}
