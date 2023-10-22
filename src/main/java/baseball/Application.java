package baseball;

import baseball.console.ConsoleInput;
import baseball.console.ConsoleOutput;
import baseball.controller.ConsoleController;
import baseball.controller.GameController;

public class Application {
	public static void main(String[] args) {
		GameController gameController = new GameController(new ConsoleController(new ConsoleInput(), new ConsoleOutput()));
		gameController.start();
	}
}
