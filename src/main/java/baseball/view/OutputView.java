package baseball.view;

import java.util.List;

public class OutputView {

	public void printStrikeAndBall(int ball, int strike) {

		if (ball != 0) {
			System.out.print(ball + "볼 ");
		}
		if (strike != 0) {
			System.out.print(strike + "스트라이크");
		}
		if (ball == 0 && strike == 0) {
			System.out.print("낫싱");
		}
		System.out.println();
	}
}
