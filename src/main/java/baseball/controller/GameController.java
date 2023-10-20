package baseball.controller;

import baseball.model.GameData;
import baseball.utils.InputValidation;
import baseball.utils.RandomGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {

	private final GameData gameData;
	private final InputView inputView;
	private final OutputView outputView;
	private final RandomGenerator randomGenerator;

	public GameController() {
		gameData = new GameData();
		inputView = new InputView();
		outputView = new OutputView();
		randomGenerator = new RandomGenerator();
	}
	public void gameStart() {
		boolean isGameStatus = true;
		outputView.printGameStart();
		gameData.setComputerNumbers(randomGenerator.generateRandomNumbers());
		while(isGameStatus) {
			gameData.setInputString(inputView.readNumber());
			List<Integer> validateResult = InputValidation.validate(gameData.getInputString());
			gameData.setPlayerNumbers(validateResult);
//			isGameStatus = !compareNumber();
			outputView.printResult(gameData.getStrikeCount(), gameData.getBallCount());
		}

		outputView.printGameEnd();
	}
}