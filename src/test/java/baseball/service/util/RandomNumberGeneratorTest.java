package baseball.service.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import baseball.service.constant.NumberConstant;

class RandomNumberGeneratorTest {
	private final RandomNumberGenerator randomNumberGenerator;

	public RandomNumberGeneratorTest() {
		randomNumberGenerator = new RandomNumberGenerator();
	}

	@Test
	void 랜덤숫자생성테스트() {
		String randomNumber = randomNumberGenerator.getRandomNumber();
		assertTrue(isValidRandomNumber(randomNumber));
	}

	private boolean isValidRandomNumber(String input) {
		if (input == null || input.length() != NumberConstant.GAME_INPUT_LENGTH.getValue()) {
			return false;
		}
		Set<Character> uniqueDigits = new HashSet<>();
		for (char digitChar : input.toCharArray()) {
			if (!isInRange(digitChar) || !uniqueDigits.add(digitChar)) {
				return false;
			}
		}
		return true;
	}

	private boolean isInRange(char digitChar) {
		int digit = Character.getNumericValue(digitChar);
		return NumberConstant.MIN_NUMBER.getValue() <= digit && digit <= NumberConstant.MAX_NUMBER.getValue();
	}
}