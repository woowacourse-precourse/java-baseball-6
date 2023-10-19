package baseball.console;

import java.io.ByteArrayInputStream;

public abstract class IOTest {
	protected void systemIn(String input) {
		System.setIn(new ByteArrayInputStream(input.getBytes()));
	}
}
