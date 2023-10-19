package baseball.ui;

import static baseball.global.constant.GameMessage.*;

public class OutputView {

	public void printGameStartMessage() {
		System.out.println(GAME_START_MESSAGE);
	}

	public void printNumberInputMessage() {
		System.out.print(NUMBER_INPUT_MESSAGE);
	}

	public void printGameResultMessage(int ballCount, int strikeCount) {
		if(ballCount == 0 && strikeCount == 0) {
			System.out.println("낫싱");
		} else if(ballCount > 0 || strikeCount > 0) {
			System.out.printf("%d볼 %d스트라이크\n", ballCount, strikeCount);
		}
	}

	public void printGameFinishMessage() {
		System.out.println("3스트라이크");
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}


}
