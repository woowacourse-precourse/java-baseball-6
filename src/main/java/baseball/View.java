package baseball;

import java.util.List;

public class View {

	public static void gameStartMessage() {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}

	public static void printScore(int strike, int ball) {
		String result = "";
		if (strike == 0 && ball == 0) {
			result = "낫싱";
		}
		if (ball != 0) {
			result += ball + "볼 ";
		}
		if (strike != 0) {
			result += strike + "스트라이크";
		}
		System.out.println(result);
	}

	public static int strike(List<Integer> randomNumber, List<Integer> userNumber) {
		int strike = 0;
		for (int i = 0; i < userNumber.size(); i++) {
			if (randomNumber.get(i).equals(userNumber.get(i))) {
				strike++;
			}
		}
		return strike;
	}

	public static int ball(List<Integer> randomNumber, List<Integer> userNumber) {
		int ball = 0;
		for (int i = 0; i < userNumber.size(); i++) {
			if (randomNumber.contains(userNumber.get(i)) && !randomNumber.get(i).equals(userNumber.get(i))) {
				ball++;
			}
		}
		return ball;
	}
}
