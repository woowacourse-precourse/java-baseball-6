package baseball.support.generator;

import baseball.domain.player.value.Ball;
import baseball.domain.player.value.Balls;
import baseball.exception.state.UtilityClassConstructorException;
import java.util.List;

public class BallGenerator {

	private BallGenerator() {
		throw new UtilityClassConstructorException();
	}

	public static Ball generate(Long number) {
		return Ball.of(number);
	}

	public static Balls generate(List<Long> numbers) {
		List<Ball> balls = numbers.stream().map(BallGenerator::generate).toList();
		return new Balls(balls);
	}
}
