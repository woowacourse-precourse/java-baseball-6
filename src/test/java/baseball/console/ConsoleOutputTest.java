package baseball.console;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import baseball.dto.BaseBallResult;

class ConsoleOutputTest extends IOTest {
	private final ConsoleOutput consoleOutput;

	public ConsoleOutputTest() {
		consoleOutput = new ConsoleOutput();
	}

	@Test
	void 볼() {
		String expectedOutput = "1볼";
		captureSystemOut(() -> consoleOutput.printResult(new BaseBallResult(1, 0)));
		assertEquals(expectedOutput, getCapturedOutput());
	}

	@Test
	void 스트라이크() {
		String expectedOutput = "1스트라이크";
		captureSystemOut(() -> consoleOutput.printResult(new BaseBallResult(0, 1)));
		assertEquals(expectedOutput, getCapturedOutput());
	}

	@Test
	void 볼스트라이크() {
		String expectedOutput = "1볼 1스트라이크";
		captureSystemOut(() -> consoleOutput.printResult(new BaseBallResult(1, 1)));
		assertEquals(expectedOutput, getCapturedOutput());
	}

	@Test
	void 낫싱() {
		String expectedOutput = "낫싱";
		captureSystemOut(() -> consoleOutput.printResult(new BaseBallResult(0, 0)));
		assertEquals(expectedOutput, getCapturedOutput());
	}
}
