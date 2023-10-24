package baseball;

public class PrintResult {

	private static final int BALL = 0;
	private static final int STRIKE = 1;
	private static final String STRING_BALL = "볼";
	private static final String STRING_STRIKE = "스트라이크";
	private static final String STRING_NOTHING = "낫싱";

	public void print(int[] result) {
		int ball = result[BALL];
		int strike = result[STRIKE];

		if (ball == 0 && strike == 0) {
			System.out.println(STRING_NOTHING);
		} else if (ball == 0) {
			System.out.println(strike + STRING_STRIKE);
		} else if (strike == 0) {
			System.out.println(ball + STRING_BALL);
		} else {
			System.out.println(ball + STRING_BALL + " " + strike + STRING_STRIKE);
		}
	}
}
