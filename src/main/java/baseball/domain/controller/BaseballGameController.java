package baseball.domain.controller;

import baseball.domain.service.BaseballGameService;
import baseball.global.util.PrintUtil;

public class BaseballGameController {

	private final BaseballGameService baseballGameService;

	public BaseballGameController(BaseballGameService baseballGameService) {
		this.baseballGameService = baseballGameService;
	}

	public void start() {
		PrintUtil.printGameStartMessage();
		do {
			baseballGameService.makeRandomNumber();
			baseballGameService.playGame();
		} while (baseballGameService.isRestart());
	}
}
