package baseball.domain.player.attacker;

import baseball.domain.player.value.Ball;
import baseball.exception.rutime.NotInitializeBallException;
import java.util.List;
import java.util.Objects;

public class ConsoleAttacker implements Attacker {

	private List<Ball> balls;

	public ConsoleAttacker() {}

	@Override
	public void initialize(List<Ball> balls) {
		this.balls = balls;
	}

	@Override
	public List<Ball> getBalls() {
		if (Objects.isNull(balls)) {
			throw new NotInitializeBallException();
		}
		return balls;
	}
}
