package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

	private static final Input input = new Input();

	private Input(){}

	public static Input getInstance(){
		return input;
	}
	public static String getNumber(){
		return Console.readLine();
	}

	public static int getMenu() {
		return Integer.parseInt(Console.readLine());
	}
}
