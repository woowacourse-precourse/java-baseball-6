package baseball.support.generator;

import baseball.domain.player.value.Ball;
import baseball.exception.state.UtilityClassConstructorException;
import java.util.List;

public class BallGenerator {

	private BallGenerator() {
		throw new UtilityClassConstructorException();
	}

	public static Ball generate(Long number) {
		return Ball.of(number);
	}

	public static List<Ball> generate(List<Long> numbers) {
		return numbers.stream().map(BallGenerator::generate).toList();
	}
}
