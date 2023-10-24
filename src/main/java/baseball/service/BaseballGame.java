package baseball.service;

import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {

	public BaseballGame() {
	}

	public void start() {
		boolean isCorrected = false;
		String targetNumber = NumberGenerator.generateUniqueNumbers(InputView.CORRECT_LENGTH);

		while (isCorrected == false) {
			String userNumber = InputView.getGameUserInput();
			isCorrected = checkTurnResult(userNumber, targetNumber);
		}
		OutputView.printGameSuccessResult();
	}

	private boolean checkTurnResult(String userNumber, String targetNumber) {
		TurnResult turnResult = Referee.getTurnResult(userNumber, targetNumber);
		OutputView.printTurnResult(turnResult.getBall(), turnResult.getStrike());
		return Referee.getGameResult(turnResult);
	}
}
