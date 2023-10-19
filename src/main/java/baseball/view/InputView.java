package baseball.view;


import baseball.constant.Constant;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public static final String INPUT_GAME_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
	public static final String INPUT_GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public static String inputGameNumberMessage() {
		String input = getInput();
		validateBlankInputGameNumber(input);
		return input;
	}

	private static void validateBlankInputGameNumber(String input) {
		if (input == null || input.isBlank()) {
			throw new IllegalArgumentException("공백 입력 예외 발생 테스트");
		}
	}


	public static String printInputGameRestartMessage() {
		System.out.println(INPUT_GAME_RESTART_MESSAGE);
		return Console.readLine();
	}

	private static String getInput() {
		return Console.readLine();
	}
}
