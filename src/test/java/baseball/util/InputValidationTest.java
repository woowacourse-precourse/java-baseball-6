package baseball.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputValidationTest {
	private final InputValidation inputValidation;

	private InputValidationTest() {
		inputValidation = new InputValidation();
	}

	@Test
	void gameInputNull() {
		assertFalse(inputValidation.isGameInputValid(null));
	}

	@Test
	void gameInputShort() {
		assertFalse(inputValidation.isGameInputValid("12"));
	}

	@Test
	void gameInputLong() {
		assertFalse(inputValidation.isGameInputValid("1234"));
	}

	@Test
	void gameInputMultiple() {
		assertFalse(inputValidation.isGameInputValid("121"));
	}

	@Test
	void gameInputNotNum() {
		assertFalse(inputValidation.isGameInputValid("a35"));
	}

	@Test
	void gameInputOutOfRange() {
		assertFalse(inputValidation.isGameInputValid("021"));
	}

	@Test
	void gameInputNegative() {
		assertFalse(inputValidation.isGameInputValid("-34"));
	}

	@Test
	void gameInputValid() {
		assertTrue(inputValidation.isGameInputValid("123"));
	}

	@Test
	void endInputNull() {
		assertFalse(inputValidation.isEndInputValid(null));
	}

	@Test
	void endInputShort() {
		assertFalse(inputValidation.isEndInputValid(""));
	}

	@Test
	void endInputLong() {
		assertFalse(inputValidation.isEndInputValid("12"));
	}

	@Test
	void endInputNotNum() {
		assertFalse(inputValidation.isEndInputValid("a"));
	}

	@Test
	void endInputOutOfRange() {
		assertFalse(inputValidation.isEndInputValid("3"));
	}

	@Test
	void endInputNegative() {
		assertFalse(inputValidation.isEndInputValid("-1"));
	}

	@Test
	void endInputValid() {
		assertTrue(inputValidation.isEndInputValid("1"));
	}
}
