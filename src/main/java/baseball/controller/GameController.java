package baseball.controller;

import baseball.service.GameService;

public class GameController {
	private final GameService gameService;

	public GameController() {
		gameService = new GameService();
	}

	public void run() {
		gameService.start();
	}
}
