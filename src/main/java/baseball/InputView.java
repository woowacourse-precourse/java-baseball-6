package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static final int GAME_START_CMD = 1;
	public static final int GAME_END_CMD = 2;
	public static final int CORRECT_LENGTH = 3;
	public static final String INPUT_GAME_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
	public static final String INPUT_GAME_PROCESS_MESSAGE =
		"게임을 새로 시작하려면 " + GAME_START_CMD + ", 종료하려면 " + GAME_END_CMD + "를 입력하세요.";

	public static String getGameUserInput() {
		System.out.print(INPUT_GAME_NUMBER_MESSAGE);
		String input = Console.readLine();

		return input;
	}

	public static boolean getProcessUserInput() {
		System.out.println(INPUT_GAME_PROCESS_MESSAGE);
		String input = Console.readLine();

		if (Integer.valueOf(input).equals(1)) {
			return true;
		}
		return false;
	}
}
