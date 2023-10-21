package baseball.console;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput {

	private ConsoleInput() {
	}

	public static String getUserNumber() {
		String inputString = Console.readLine();
		return inputString;
	}


}
