package baseball.controller;

import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
	private final GameService gameService;
	public static final String RESTART = "1";
	public static final String END = "2";

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
		return Console.readLine().equals(RESTART);
	}
}
