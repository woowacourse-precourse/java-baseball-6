package baseball.view;

public class OutputView {
	private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
	private static final String STRIKE = "스트라이크";
	private static final String BALL = "볼";
	private static final String NOTHING = "낫싱";
	public void printGameStartMessage() {
		System.out.println(GAME_START_MESSAGE);
	}

	public void printResult(int strike, int ball) {

		String strikeCount = String.format("%d%s",strike,STRIKE);
		String ballCount = String.format("%d%s",ball,BALL);

		if(strike > 0 && ball == 0) {
			System.out.println(strikeCount);
		}
		if(ball > 0 && strike == 0) {
			System.out.println(ballCount);
		}
		if(strike > 0 && ball > 0) {
			System.out.println(ballCount + " " +strikeCount);
		}
		if(strike == 0 && ball == 0) {
			System.out.println(NOTHING);
		}
	}
}
