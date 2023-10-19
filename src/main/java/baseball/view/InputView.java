package baseball.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {

	private static final String INPUT_GAME_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

	public static String printInputGameNumberMessage() {
		System.out.print(INPUT_GAME_NUMBER_MESSAGE);
		return Console.readLine();
	}
}
