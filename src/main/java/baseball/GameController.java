package baseball;

public class GameController {
	public void start() {
		OutputView.printGameStart();
		BaseballGame baseballGame = new BaseballGame();
		do {
			baseballGame.start();
		} while (InputView.getProcessUserInput());
	}
}
