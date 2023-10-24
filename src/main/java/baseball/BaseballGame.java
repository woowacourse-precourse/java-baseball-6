package baseball;

public class BaseballGame {

	public BaseballGame() {
	}

	public void start() {
		OutputView.printGameStart();
		boolean isCorrected = false;
		// TODO: 랜덤한 숫자를 생성하는 로직 구현 필요
		String targetNumber = "123";

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
