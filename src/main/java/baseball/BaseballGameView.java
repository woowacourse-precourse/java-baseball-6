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

		displayMessage("숫자를 입력해주세요 : ");
		String input = Console.readLine();

		String[] tempList = input.split("");

		// 사용자 입력값의 자리수가 3자리가 아니면 프로그램 종료
		if (input.length() != BaseballGameModel.getMaxSizeNumber()) {
			// try/catch문 제거: 예외를 상위 호출자에서 처리하면서 프로그램이 종료
			throw new IllegalArgumentException("3자리 수를 입력해야 합니다.\n게임 종료!");
		}

		for (int i = 0; i < BaseballGameModel.getMaxSizeNumber(); i++) {
			guessNumberList[i] = Integer.parseInt(tempList[i]);
		}

		// 사용자 입력값이 중복이면 프로그램 종료
		for (int i = 0; i < guessNumberList.length - 1; i++) {
			for (int j = i + 1; j < guessNumberList.length; j++) {
				if (guessNumberList[i] == guessNumberList[j]) {
					// try/catch문 제거
					throw new IllegalArgumentException("서로 다른 수를 입력해야 합니다.\n게임 종료!");
				}
			}
		}

		return guessNumberList;
	}

	public int getNewGameChoice() {

		displayMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
		String input = Console.readLine();
		int inputToNumber = Integer.parseInt(input);

		if (inputToNumber != 1 && inputToNumber != 2) {
			// try/catch문 제거
			throw new IllegalArgumentException("1과 2 중 선택해주세요.\n게임 종료!");
		}

		return inputToNumber;
	}

}
