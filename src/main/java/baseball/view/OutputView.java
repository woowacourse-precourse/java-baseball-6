package baseball.view;

public class OutputView {
	public static void printStartGame() {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}

	public static void printEndGame() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	public static void printHint(int ballCount, int strikeCount) {
		String print = "";
		if (ballCount == 0 && strikeCount == 0) {
			print += "낫싱";
		}
		if (ballCount != 0) {
			print += ballCount;
			print += "볼";
		}
		if (strikeCount != 0) {
			if (ballCount != 0) {
				print += " ";
			}
			print += strikeCount;
			print += "스트라이크";
		}
		System.out.println(print);
	}
}
