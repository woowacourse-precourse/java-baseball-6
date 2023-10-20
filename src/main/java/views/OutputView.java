package views;

public class OutputView {
	public OutputView() {

	}

	public void printCheckResult(int strikeCount, int ballCount) {
		if (strikeCount == 0 && ballCount == 0) {
			System.out.println("낫싱");
			return;
		}
		if (strikeCount == 0) {
			System.out.println(ballCount + "볼");
			return;
		}
		if (ballCount == 0) {
			System.out.println(strikeCount + "스트라이크");
			return;
		}
		System.out.println(strikeCount + "스트라이크 " + ballCount + "볼");
	}
}
