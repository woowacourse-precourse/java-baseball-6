package baseball;

import java.util.List;

public class GameController {

	private Balls createAnswerBalls() {
		List<Integer> numbers = RandomNumberGenerator.generate();
		return Balls.of(numbers);
	}
}