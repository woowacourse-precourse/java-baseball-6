package baseball.domain.command;

import java.util.Arrays;

public enum Continue {

	NEW(1), QUIT(2);

	private final int command;

	Continue(int command) {
		this.command = command;
	}

	public static boolean checkContinue(int num) {
		if (num == Continue.NEW.getCommand()) {
			return true;
		}
		return false;
	}

	public static boolean checkContinueCommand(int num) {
		return Arrays.stream(Continue.values())
				.anyMatch(command -> command.getCommand() == num);
	}

	public int getCommand() {
		return command;
	}
}
