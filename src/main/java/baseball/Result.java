package baseball;

public class Result {
	private int nothing;
	private int ball;
	private int strike;

	public void increaseNothing() {
		nothing++;
	}

	public void increaseBall() {
		ball++;
	}

	public void increaseStrike() {
		strike++;
	}

	public int getNothing() {
		return nothing;
	}

	public int getBall() {
		return ball;
	}

	public int getStrike() {
		return strike;
	}

	@Override
	public String toString() {
		String output = "";
		if (nothing == 3) {
			output = "낫싱";
		}
		if (ball > 0) {
			output += ball + "볼 ";
		}
		if (strike > 0) {
			output += strike + "스트라이크";
		}
		return output;
	}
}
