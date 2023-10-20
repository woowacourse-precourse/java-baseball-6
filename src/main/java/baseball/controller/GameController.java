package baseball.controller;

import baseball.model.GameData;
import baseball.utils.RandomGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

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
}