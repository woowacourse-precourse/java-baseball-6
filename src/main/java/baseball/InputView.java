package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static final int GAME_START_CMD = 1;
	public static final int GAME_END_CMD = 2;
	public static final int CORRECT_LENGTH = 3;
	public static final int AVAILABLE_START_NUMBER = 1;
	public static final int AVAILABLE_END_NUMBER = 9;

	public static final String WRONG_COMMAND_EXCEPTION_MESSAGE =
		"올바른 게임 명령어가 입력되지 않았습니다.";
	public static final String WRONG_LENGTH_EXCEPTION_MESSAGE = "게임 입력으로 " + CORRECT_LENGTH + "자리 숫자를 입력해야 합니다.";
	public static final String SAME_NUMBER_EXCEPTION_MESSAGE = "게임 입력으로 모두 다른 숫자를 입력해야 합니다.";
	public static final String WRONG_RANGE_NUMBER_EXCEPTION_MESSAGE = "게임 입력으로 1 ~ 9 사이의 숫자를 입력해야 합니다.";
	public static final String INPUT_GAME_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
	public static final String INPUT_GAME_PROCESS_MESSAGE =
		"게임을 새로 시작하려면 " + GAME_START_CMD + ", 종료하려면 " + GAME_END_CMD + "를 입력하세요.";

	public static String getGameUserInput() {
		System.out.print(INPUT_GAME_NUMBER_MESSAGE);
		String input = Console.readLine();

		validateGameNumber(input);

		return input;
	}

	private static void validateGameNumber(String input) {
		if (input.length() != CORRECT_LENGTH) {
			throw new IllegalArgumentException(WRONG_LENGTH_EXCEPTION_MESSAGE);
		}
		if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(
			2)) {
			throw new IllegalArgumentException(SAME_NUMBER_EXCEPTION_MESSAGE);
		}
		for (int i = 0; i < CORRECT_LENGTH; i++) {
			if (input.charAt(i) < AVAILABLE_START_NUMBER || input.charAt(i) > AVAILABLE_END_NUMBER) {
				throw new IllegalArgumentException(WRONG_RANGE_NUMBER_EXCEPTION_MESSAGE);
			}
		}
		validateInputNumber(input);
	}

	public static boolean getProcessUserInput() {
		System.out.println(INPUT_GAME_PROCESS_MESSAGE);
		String input = Console.readLine();

		return validateCommandNumber(input);
	}

	private static boolean validateCommandNumber(String input) {
		validateInputNumber(input);
		if (Integer.valueOf(input).equals(1)) {
			return true;
		}
		if (Integer.valueOf(input).equals(2)) {
			return false;
		}
		throw new IllegalArgumentException(WRONG_COMMAND_EXCEPTION_MESSAGE);
	}

	private static boolean validateInputNumber(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자를 입력해야 합니다.");
		}
	}
}
