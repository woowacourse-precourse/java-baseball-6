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

	public void printEnd() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	public void gameOver() {
		System.out.println("게임 종료");
	}
}
