package baseball.domain.player.attacker;

import baseball.domain.player.value.Balls;
import baseball.exception.rutime.NotInitializeBallException;
import java.util.Objects;

public class ConsoleAttacker implements Attacker {

	private Balls balls;

	public ConsoleAttacker() {}

	@Override
	public void initialize(Balls balls) {
		this.balls = balls;
	}

	@Override
	public Balls attack() {
		if (Objects.isNull(balls)) {
			throw new NotInitializeBallException();
		}
		return balls;
	}
}
