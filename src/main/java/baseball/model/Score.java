package baseball.model;

import java.util.List;

public class Score {
	private int ball;
	private int strike;

	public Score() {
		this.ball = 0;
		this.strike = 0;
	}

	public void countScore(List<Integer> userNumber, List<Integer> computerNumber) {
		for (int i = 0; i < 3; i++) {

			if (userNumber.get(i).equals(computerNumber.get(i))) {
				this.strike++;
				continue;
			}

			if (computerNumber.contains(userNumber.get(i))) {
				this.ball++;
			}
		}
	}

	public int getBall() {
		return ball;
	}

	public int getStrike() {
		return strike;
	}
}
