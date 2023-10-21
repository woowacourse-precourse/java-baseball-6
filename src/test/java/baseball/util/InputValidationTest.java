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
		assertFalse(inputValidation.isValidGameInput(null));
	}

	@Test
	void gameInputShort() {
		assertFalse(inputValidation.isValidGameInput("12"));
	}

	@Test
	void gameInputLong() {
		assertFalse(inputValidation.isValidGameInput("1234"));
	}

	@Test
	void gameInputMultiple() {
		assertFalse(inputValidation.isValidGameInput("121"));
	}

	@Test
	void gameInputNotNum() {
		assertFalse(inputValidation.isValidGameInput("a35"));
	}

	@Test
	void gameInputOutOfRange() {
		assertFalse(inputValidation.isValidGameInput("021"));
	}

	@Test
	void gameInputNegative() {
		assertFalse(inputValidation.isValidGameInput("-34"));
	}

	@Test
	void gameInputValid() {
		assertTrue(inputValidation.isValidGameInput("123"));
	}

	@Test
	void endInputNull() {
		assertFalse(inputValidation.isValidEndInput(null));
	}

	@Test
	void endInputShort() {
		assertFalse(inputValidation.isValidEndInput(""));
	}

	@Test
	void endInputLong() {
		assertFalse(inputValidation.isValidEndInput("12"));
	}

	@Test
	void endInputNotNum() {
		assertFalse(inputValidation.isValidEndInput("a"));
	}

	@Test
	void endInputOutOfRange() {
		assertFalse(inputValidation.isValidEndInput("3"));
	}

	@Test
	void endInputNegative() {
		assertFalse(inputValidation.isValidEndInput("-1"));
	}

	@Test
	void endInputValid() {
		assertTrue(inputValidation.isValidEndInput("1"));
	}
}
