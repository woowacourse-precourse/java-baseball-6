package baseball;

import camp.nextstep.edu.missionutils.Console;

// View: 사용자 인터페이스와 피드백을 담당
public class BaseballGameView {
	public void displayMessage(String message) {
		System.out.print(message);
	}

	// 사용자로부터 숫자 입력을 받고 배열로 변환
	public int[] getGuessFromUser() {
		int[] guessNumberList = new int[BaseballGameModel.getMaxSizeNumber()];
		try {
			displayMessage("숫자를 입력해주세요 : ");
			String input = Console.readLine();

			String[] tempList = input.split("");

			// 사용자 입력값의 자리수가 3자리가 아니면 프로그램 종료
			if (input.length() != BaseballGameModel.getMaxSizeNumber()) {
				throw new IllegalArgumentException();
			}

			for (int i = 0; i < BaseballGameModel.getMaxSizeNumber(); i++) {
				guessNumberList[i] = Integer.parseInt(tempList[i]);
			}

			// 사용자 입력값이 중복이면 프로그램 종료
			for (int i = 0; i < guessNumberList.length - 1; i++) {
				for (int j = i + 1; j < guessNumberList.length; j++) {
					if (guessNumberList[i] == guessNumberList[j]) {
						throw new IllegalArgumentException();
					}
				}
			}

		} catch (IllegalArgumentException e) {
			guessNumberList = null; // 프로그램 종료

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
			inputToNumber = 2;	// return값을 2로 저장하여 게임 종료시키기
		}
		return inputToNumber;
	}

}
