package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

	private static final Input input = new Input();

	private Input() {
	}

	public static String getNumber() {
		return Console.readLine();
	}

	public static String getMenu() {
		return Console.readLine();
	}
}
