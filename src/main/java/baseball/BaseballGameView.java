package baseball;

import camp.nextstep.edu.missionutils.Console;

// View: 사용자 인터페이스와 피드백을 담당
public class BaseballGameView {
	public void displayMessage(String message) {
		System.out.print(message);
	}

	public int[] getGuessFromUser() {
		int[] guessNumberList = new int[BaseballGameModel.getMaxSizeNumber()];
		// 사용자로부터 숫자 입력을 받고 배열로 변환
		try {
			displayMessage("숫자를 입력해주세요 : ");
			String input = Console.readLine();

			String[] tempList = input.split("");

			if (input.length() != BaseballGameModel.getMaxSizeNumber()) {
				throw new IllegalArgumentException();
			}

			for (int i = 0; i < BaseballGameModel.getMaxSizeNumber(); i++) {
				guessNumberList[i] = Integer.parseInt(tempList[i]);
			}

			for (int i = 0; i < guessNumberList.length - 1; i++) {
				for (int j = i + 1; j < guessNumberList.length; j++) {
					if (guessNumberList[i] == guessNumberList[j]) {
						throw new IllegalArgumentException();
					}
				}
			}

		} catch (IllegalArgumentException e) {
			System.exit(1); // 프로그램 종료

		}
		return guessNumberList;
	}

	public int getNewGameChoice() {
		int inputToNumber = 0;

		try {
			displayMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
			String input = Console.readLine();
			inputToNumber = Integer.parseInt(input);

			if (inputToNumber != 1 && inputToNumber != 2) {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.exit(1);
		}
		return inputToNumber;
	}

}
