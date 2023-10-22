package baseball.controller;

import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
	private final GameService gameService;
	public static int NUMBER_SIZE = 3;
	public static final String RESTART_NUMBER = "1";

	public GameController() {
		gameService = new GameService();
	}

	public void run() {
		OutputView.printStart();
		do {
			gameService.start();
			OutputView.printEnd();
		} while(checkRestart());
	}

	public boolean checkRestart() {
		InputView.askRestart();
		return Console.readLine().equals(RESTART_NUMBER);
	}
}
