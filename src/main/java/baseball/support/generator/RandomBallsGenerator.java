package baseball.support.generator;

import baseball.domain.player.value.Balls;
import baseball.exception.state.UtilityClassConstructorException;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomBallsGenerator {

	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;

	private RandomBallsGenerator() {
		throw new UtilityClassConstructorException();
	}

	public static Balls generate(Long size) {
		List<Long> numbers = new ArrayList<>();
		while (numbers.size() < size) {
			long randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
			if (!numbers.contains(randomNumber)) {
				numbers.add(randomNumber);
			}
		}

		return BallGenerator.generate(numbers);
	}
}
