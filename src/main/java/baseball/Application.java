package baseball;

import baseball.controller.BaseBallController;

public class Application {
	public static void main(String[] args) {
		while (true) {
			BaseBallController baseBallController = new BaseBallController();
			if (!baseBallController.playGame()) {
				break;
			}
		}
	}
}
