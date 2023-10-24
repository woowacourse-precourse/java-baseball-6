package baseball;

import java.util.List;

public class Game {
	private int ball;
	private int strike;

	public Game(int ball, int strike) {
		this.ball = ball;
		this.strike = strike;
	}

	public void calculateCount(List<Integer> userNumbers, List<Integer> computerNumbers) {
		for (int k = 0; k < userNumbers.size(); k++) {
			if (userNumbers.get(k) == computerNumbers.get(k)) {
				addStrike();
			}

			if (userNumbers.get(k) != computerNumbers.get(k) && computerNumbers.contains(userNumbers.get(k))) {
				addBall();
			}
		}
	}

	public int getBall() {
		return ball;
	}

	public int getStrike() {
		return strike;
	}

	private void addBall() {
		ball += 1;
	}

	private void addStrike() {
		strike += 1;
	}
}
