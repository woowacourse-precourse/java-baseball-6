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

	@Test
	void endInputNull() {
		assertTrue(inputValidation.isEndInputValid(null));
	}

	@Test
	void endInputShort() {
		assertTrue(inputValidation.isEndInputValid(""));
	}

	@Test
	void endInputLong() {
		assertTrue(inputValidation.isEndInputValid("12"));
	}

	@Test
	void endInputNotNum() {
		assertTrue(inputValidation.isEndInputValid("a"));
	}

	@Test
	void endInputOutOfRange() {
		assertTrue(inputValidation.isEndInputValid("3"));
	}

	@Test
	void endInputNegative() {
		assertTrue(inputValidation.isEndInputValid("-1"));
	}

	@Test
	void endInputValid() {
		assertTrue(inputValidation.isEndInputValid("1"));
	}
}
