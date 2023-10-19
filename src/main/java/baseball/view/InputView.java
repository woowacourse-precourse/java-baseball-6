package baseball.view;


import baseball.constant.Constant;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public static final String INPUT_GAME_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
	public static final String INPUT_GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	private static final String  GAME_RESTART_NUMBER = "1";
	private static final String  GAME_END_NUMBER = "2";

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


	public static String inputGameRestartMessage() {
		String input = getInput();
		validateWrongGameRestartInput(input);
		return input;
	}

	private static void validateWrongGameRestartInput(String input) {
		if (!input.equals(GAME_RESTART_NUMBER) && !input.equals(GAME_END_NUMBER)) {
			throw new IllegalArgumentException("잘못된 재시작 입력 예외 발생 테스트");
		}
	}

	private static String getInput() {
		return Console.readLine();
	}
}
