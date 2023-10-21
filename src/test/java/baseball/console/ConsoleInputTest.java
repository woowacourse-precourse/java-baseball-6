package baseball.console;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Console;

class ConsoleInputTest extends IOTest {
	private final ConsoleInput consoleInput;

	public ConsoleInputTest() {
		consoleInput = new ConsoleInput();
	}

	@AfterEach
	void teardown() {
		Console.close();
		System.setIn(System.in);
	}

	@Test
	void 세자리입력테스트() {
		String input = "123";
		systemIn(input);
		assertEquals(input, consoleInput.getGameInput());
	}

	@Test
	void 게임재시작입력테스트() {
		String input = "1";
		systemIn(input);
		assertEquals(input, consoleInput.getEndInput());
	}

	@Test
	void 게임종료입력테스트() {
		String input = "2";
		systemIn(input);
		assertEquals(input, consoleInput.getEndInput());
	}
}
