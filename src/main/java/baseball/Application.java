package baseball;

import baseball.service.GameService;

public class Application {
	public static void main(String[] args) {
		new GameService().run();
	}
}
