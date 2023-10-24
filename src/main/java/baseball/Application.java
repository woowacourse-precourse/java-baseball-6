package baseball;

import baseball.domain.game.Game;
import baseball.initializer.GameInitializer;

public class Application {
	public static void main(String[] args) {
		Game game = GameInitializer.getGame();
		game.start();
	}
}
