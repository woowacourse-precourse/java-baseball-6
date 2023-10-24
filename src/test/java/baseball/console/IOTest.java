package baseball.console;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public abstract class IOTest {
	protected ByteArrayOutputStream capturedOutput;

	protected void systemIn(String input) {
		System.setIn(new ByteArrayInputStream(input.getBytes()));
	}

	protected void captureSystemOut(Runnable runnable) {
		capturedOutput = new ByteArrayOutputStream();
		PrintStream originalOut = System.out;
		System.setOut(new PrintStream(capturedOutput));
		runnable.run();
		System.setOut(originalOut);
	}

	protected String getCapturedOutput() {
		return capturedOutput.toString().trim();
	}
}
