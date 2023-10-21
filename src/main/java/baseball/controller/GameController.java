package baseball.controller;

import baseball.model.GameData;
import baseball.utils.InputValidation;
import baseball.utils.RandomGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;
import java.util.Objects;

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
			List<Integer> validateResult =
				InputValidation.validateAndConvertInputToIntegerList(gameData.getInputString());
			gameData.setPlayerNumbers(validateResult);
			isGameStatus = !compareNumber();
			outputView.printResult(gameData.getStrikeCount(), gameData.getBallCount());
		}
		if(isRestartRequested()) {
			gameStart();
			return;
		}
		outputView.printGameEnd();
	}
	public boolean compareNumber() {
		gameData.initCount();
		List<Integer> playerNumbers = gameData.getPlayerNumbers();
		List<Integer> computerNumbers = gameData.getComputerNumbers();
		for(int i = 0; i < playerNumbers.size(); i++) {
			if(Objects.equals(playerNumbers.get(i), computerNumbers.get(i))) {
				gameData.incStrikeCount();
				continue;
			}
			if(computerNumbers.contains(playerNumbers.get(i))) {
				gameData.incBallCount();
			}
		}
		return gameData.getStrikeCount() == 3;
	}
	public boolean isRestartRequested() {
		String restartInput = inputView.readRestart();
		String validatedRestartInput = InputValidation.validateRestartInput(restartInput);
		return validatedRestartInput.equals("1");
	}

}