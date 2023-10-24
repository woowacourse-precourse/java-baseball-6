package baseball.console.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputValidationTest {
	private final InputValidation inputValidation;

	private InputValidationTest() {
		inputValidation = new InputValidation();
	}

	@Test
	void 게임중_null입력테스트() {
		assertFalse(inputValidation.isValidGameInput(null));
	}

	@Test
	void 게임중_짧은입력테스트() {
		assertFalse(inputValidation.isValidGameInput("12"));
	}

	@Test
	void 게임중_긴입력테스트() {
		assertFalse(inputValidation.isValidGameInput("1234"));
	}

	@Test
	void 게임중_중복입력테스트() {
		assertFalse(inputValidation.isValidGameInput("121"));
	}

	@Test
	void 게임중_문자입력테스트() {
		assertFalse(inputValidation.isValidGameInput("a35"));
	}

	@Test
	void 게임중_숫자0입력테스트() {
		assertFalse(inputValidation.isValidGameInput("021"));
	}

	@Test
	void 게임중_음수입력테스트() {
		assertFalse(inputValidation.isValidGameInput("-34"));
	}

	@Test
	void 게임중_정상입력테스트() {
		assertTrue(inputValidation.isValidGameInput("123"));
	}

	@Test
	void 종료시_null입력테스트() {
		assertFalse(inputValidation.isValidEndInput(null));
	}

	@Test
	void 종료시_짧은입력테스트() {
		assertFalse(inputValidation.isValidEndInput(""));
	}

	@Test
	void 종료시_긴입력테스트() {
		assertFalse(inputValidation.isValidEndInput("12"));
	}

	@Test
	void 종료시_문자입력테스트() {
		assertFalse(inputValidation.isValidEndInput("a"));
	}

	@Test
	void 종료시_범위보다큰입력테스트() {
		assertFalse(inputValidation.isValidEndInput("3"));
	}

	@Test
	void 종료시_음수입력테스트() {
		assertFalse(inputValidation.isValidEndInput("-1"));
	}

	@Test
	void 종료시_재시작정상입력테스트() {
		assertTrue(inputValidation.isValidEndInput("1"));
	}

	@Test
	void 종료시_종료정상입력테스트() {
		assertTrue(inputValidation.isValidEndInput("2"));
	}
}
