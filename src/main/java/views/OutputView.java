package views;

public class OutputView {
	public OutputView() {

	}
	public static void printIntro() {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}

	public void printInputMent() {
		System.out.print("숫자를 입력해주세요 : ");
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
		System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
	}

	public void printEnd() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	public void printOpinionMent() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}

	public void printGameOver() {
		System.out.println("게임 종료");
	}
}
