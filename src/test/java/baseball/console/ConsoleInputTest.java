package baseball.console;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import baseball.console.util.InputValidation;
import camp.nextstep.edu.missionutils.Console;

class ConsoleInputTest extends IOTest {
	private final ConsoleInput consoleInput;
	private final InputValidation inputValidation;

	public ConsoleInputTest() {
		consoleInput = new ConsoleInput();
		inputValidation = new InputValidation();
	}

	@AfterEach
	void teardown() {
		Console.close();
		System.setIn(System.in);
	}

	@Test
	void 세자리_정상입력테스트() {
		String testInput = "123";
		systemIn(testInput);
		String actualInput = consoleInput.getGameInput();
		assertTrue(inputValidation.isValidGameInput(actualInput));
		assertEquals(testInput, actualInput);
	}

	@Test
	void 세자리_긴입력테스트() {
		String testInput = "1234";
		systemIn(testInput);
		Assertions.assertThrows(IllegalArgumentException.class, consoleInput::getGameInput);
	}

	@Test
	void 세자리_짧은입력테스트() {
		String testInput = "12";
		systemIn(testInput);
		Assertions.assertThrows(IllegalArgumentException.class, consoleInput::getGameInput);
	}

	@Test
	void 세자리_문자입력테스트() {
		String testInput = "a12";
		systemIn(testInput);
		Assertions.assertThrows(IllegalArgumentException.class, consoleInput::getGameInput);
	}

	@Test
	void 세자리_음수입력테스트() {
		String testInput = "-12";
		systemIn(testInput);
		Assertions.assertThrows(IllegalArgumentException.class, consoleInput::getGameInput);
	}

	@Test
	void 세자리_0입력테스트() {
		String testInput = "120";
		systemIn(testInput);
		Assertions.assertThrows(IllegalArgumentException.class, consoleInput::getGameInput);
	}

	@Test
	void 한자리_재시작입력테스트() {
		String testInput = "1";
		systemIn(testInput);
		String actualInput = consoleInput.getEndInput();
		assertTrue(inputValidation.isValidEndInput(actualInput));
		assertEquals(testInput, actualInput);
	}

	@Test
	void 한자리_종료입력테스트() {
		String testInput = "2";
		systemIn(testInput);
		String actualInput = consoleInput.getEndInput();
		assertTrue(inputValidation.isValidEndInput(actualInput));
		assertEquals(testInput, actualInput);
	}

	@Test
	void 한자리_범위밖입력테스트() {
		String testInput = "3";
		systemIn(testInput);
		Assertions.assertThrows(IllegalArgumentException.class, consoleInput::getGameInput);
	}
}
