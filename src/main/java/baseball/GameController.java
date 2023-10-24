package baseball;

import camp.nextstep.edu.missionutils.Console;

// 게임을 재시작하거나 종료하는 기능
public class GameController {

	static void restartOrEndGame() {

		final String END_SIGN = "2";

		String controlSign = "";

		while (!controlSign.equals(END_SIGN)) {

			GamePlay.playGame();

			printInputControlSign();
			controlSign = Console.readLine();

			checkControlSign(controlSign);

		}
	}

	static void printInputControlSign() {

		final String END_SIGN = "2";
		final String RESTART_SIGH = "1";
		final int COMPUTER_NUMBER_SIZE = 3;

		System.out.println(COMPUTER_NUMBER_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 " + RESTART_SIGH + ", 종료하려면 " + END_SIGN + "를 입력하세요.");
	}

	static void checkControlSign(String controlSign) {

		final String END_SIGN = "2";
		final String RESTART_SIGH = "1";

		if (!(controlSign.equals(RESTART_SIGH) || controlSign.equals(END_SIGN))) {
			throw new IllegalArgumentException(RESTART_SIGH + "이나 " + END_SIGN + "만 입력해주세요");
		}
	}

}
