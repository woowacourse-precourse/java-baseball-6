package baseball.game.balls;

import java.util.List;

public class Balls {

	private List<Integer> balls;

	public Balls(List<Integer> balls) {
		this.balls = balls;
	}

	public List<Integer> getBalls() {
		return balls;
	}

	public void setBalls(List<Integer> balls) {
		this.balls = balls;
	}
}