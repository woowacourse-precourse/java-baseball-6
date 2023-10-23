package baseball;

public class Output {
	
	public static void startGamet() {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}

	public static void displayGameResult(int strike, int ball) {	
		if (strike == 0 && ball == 0) {
			System.out.println("낫싱");
		}
		if (strike == 0 && ball != 0) {
			System.out.println(ball + "볼");
		}
		if (strike != 0 && ball == 0) {
			System.out.println(strike + "스트라이크");
			displayPlayerWin(strike);
		}
		if (strike != 0 && ball != 0) {
			System.out.println(ball + "볼 " + strike + "스트라이크");
		}
	}
	
	public static void displayPlayerWin(int strike) {
		if (strike == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		}
	}
}
