package baseball.view;

public class OutputView {

	private static final String START_GUIDE = "숫자 야구 게임을 시작합니다.";
	private static final String NUMBERS_INPUT_GUIDE = "숫자를 입력해주세요 : ";
	private static final String GAME_END_GUIDE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String REPLAY_GUIDE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public static void printStartGuide() {
		System.out.println(START_GUIDE);
	}

	public static void printNumbersInputGuide() {
		System.out.print(NUMBERS_INPUT_GUIDE);
	}

	public static void printGameResultMessage(String gameResultMessage) {
		System.out.println(gameResultMessage);
	}

	public static void printGameEndGuide() {
		System.out.println(GAME_END_GUIDE);
		System.out.println(REPLAY_GUIDE);
	}

}
