package baseball;

public class Result {
	public static void printResult(int ball, int strike) {
		if (ball != 0 && strike == 0) {
			System.out.println(ball + "볼");
			return;
		}

		if (ball == 0 && strike != 0) {
			System.out.println(strike + "스트라이크");
			return;
		}

		if (ball != 0) {
			System.out.println(ball + "볼 " + strike + "스트라이크");
			return;
		}
		System.out.println("낫싱");
	}

	public static void printSuccessMessage() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	public static void printRetryOrExitMessage() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}
}
