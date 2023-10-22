package baseball.domain.player.defender.support;

import baseball.domain.player.value.Ball;
import java.util.Map;

public class BallSource {

	private final Map<Ball, Integer> balls;

	/** key : ball, value : index */
	public BallSource(Map<Ball, Integer> balls) {
		this.balls = balls;
	}

	public Integer getIndex(Ball ball) {
		return balls.get(ball);
	}
}
