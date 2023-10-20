package baseball.view;

public class OutputView {
	private static final String MESSAGE_GAME_START = "숫자 야구 게임을 시작합니다.";
	private static final String MESSAGE_INPUT_NUMBER = "숫자를 입력해주세요 : ";
	private static final String MESSAGE_GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	public void printGameStart() {
		System.out.println(MESSAGE_GAME_START);
	}
	public void printGameEnd() {
		System.out.println(MESSAGE_GAME_END);
	}
	public static void printInputNumber() {
		System.out.print(MESSAGE_INPUT_NUMBER);
	}

}
