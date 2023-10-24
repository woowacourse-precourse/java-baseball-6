package baseball;

public class OutputView {
	public static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
	public static final String SUCCESS_GAME_MESSAGE = InputView.CORRECT_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
	public static final String BALL = "볼";
	public static final String STRIKE = "스트라이크";
	public static final String NOTHING = "낫싱";

	public static void printGameStart() {
		System.out.println(START_GAME_MESSAGE);
	}

	public static void printGameSuccessResult() {
		System.out.println(SUCCESS_GAME_MESSAGE);
	}

	public static void printTurnResult(int ball, int strike) {
		StringBuilder output = new StringBuilder();
		if (ball == 0 && strike == 0) {
			output.append(NOTHING);
		}
		if (ball > 0) {
			output.append(ball).append(BALL);
		}
		if (ball > 0 && strike > 0) {
			output.append(" ").append(strike).append(STRIKE);
		}
		if (ball == 0 && strike > 0) {
			output.append(strike).append(STRIKE);
		}
		System.out.println(output);
	}
}
