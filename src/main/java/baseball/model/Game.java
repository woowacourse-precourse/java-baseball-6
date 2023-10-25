package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private List<Integer> gameNumbers = new ArrayList<>();
	private int strikeCount;
	private int ballCount;

	public void setGameNumbers(List<Integer> gameNumbers) {
		this.gameNumbers = gameNumbers;
	}

	public List<Integer> getGameNumbers() {
		return this.gameNumbers;
	}

	public void setStrikeCountAndBallCount(int strikeCount, int ballCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
	}

	public int getStrikeCount() {
		return this.strikeCount;
	}

	public int getBallCount() {
		return this.ballCount;
	}
}
