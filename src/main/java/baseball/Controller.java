package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class Controller {

	private Validator validator;

	public Controller(Validator validator) {
		this.validator = validator;
	}

	public void run() {
		OutputView.printMessage("숫자 야구 게임을 시작합니다.");
		do {
			proceed();
		} while (isRestartGame());
	}

	private void proceed() {
		GameData gameData = new GameData();
		initGame(gameData);         // 게임 초기화
		proceedGame(gameData);      // 게임 진행
		endGame();                  // 게임 종료
	}

	private void initGame(GameData gameData) {
		gameData.initComputer();
	}

	private void proceedGame(GameData gameData) {
		while (true) {
			List<Integer> trial = validator.validateBaseballNumber(InputView.readBaseballNumber());
			List<Integer> result = gameData.calculateResult(trial);
			OutputView.printResult(result);
			if (isThreeStrike(result)) {
				return;
			}
		}
	}

	private boolean isThreeStrike(List<Integer> result) {
		return result.get(1) == 3;
	}

	private void endGame() {
		OutputView.printMessage("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	private boolean isRestartGame() {
		return validator.validatedRestart(InputView.readRestart()) == 1;
	}
}
