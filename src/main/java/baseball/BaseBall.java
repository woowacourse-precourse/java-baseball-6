package baseball;

import java.util.Scanner;

public class BaseBall {
	Scanner scanner = new Scanner(System.in);

	void startGame(){
		int gameFlag = 1;

		while (gameFlag == 1) {
			baseBallGame();
			
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			gameFlag = scanner.nextInt();

			if (gameFlag == 2) {
				return;
			} else if (gameFlag != 1) {
				throw new IllegalArgumentException();
			}
		}
	}

	private void baseBallGame() {
	}
}
