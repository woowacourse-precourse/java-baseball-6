package baseball.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputValidationTest {
	private InputValidation inputValidation = new InputValidation();

	@Test
	void gameInputNull() {
		assertTrue(inputValidation.isGameInputValid(null));
	}

	@Test
	void gameInputShort() {
		assertTrue(inputValidation.isGameInputValid("12"));
	}

	@Test
	void gameInputLong() {
		assertTrue(inputValidation.isGameInputValid("1234"));
	}

	@Test
	void gameInputMultiple() {
		assertTrue(inputValidation.isGameInputValid("121"));
	}

	@Test
	void gameInputNotNum() {
		assertTrue(inputValidation.isGameInputValid("a35"));
	}

	@Test
	void gameInputOutOfRange() {
		assertTrue(inputValidation.isGameInputValid("021"));
	}

	@Test
	void gameInputNegative() {
		assertTrue(inputValidation.isGameInputValid("-34"));
	}

	@Test
	void gameInputValid() {
		assertTrue(inputValidation.isGameInputValid("123"));
	}
}
