package baseball;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import baseball.domain.RandomNumbersGenerator;

public class RandomNumbersGeneratorTest {

	private final RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator();

	@Test
	void 생성된_랜덤_숫자는_3자리이다() {
		List<Integer> randomNumbers = randomNumbersGenerator.generateRandomNumbers();

		Assertions.assertThat(randomNumbers.size()).isEqualTo(3);
	}

	@Test
	void 생성된_각각의_랜덤_숫자는_1과9_사이의_숫자이다() {
		List<Integer> randomNumbers = randomNumbersGenerator.generateRandomNumbers();

		for(Integer number : randomNumbers) {
			Assertions.assertThat(number).isBetween(0,10);
		}
	}
}
