package baseball.controller;

import baseball.constant.Constant;
import baseball.view.InputView;

public class BaseballGameController {


	public BaseballGameController() {
	}

	public void gamePlay() {
		gameProcess();
	}

	private void gameProcess() {
		createUserGameNumber();
	}

	private String createUserGameNumber() {
		String input = Constant.BLANK_VALUE;
		try {
			System.out.print(InputView.INPUT_GAME_NUMBER_MESSAGE);
			input = InputView.inputGameNumberMessage();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		return input;
	}
}
