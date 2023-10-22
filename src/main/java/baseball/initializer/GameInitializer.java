package baseball.initializer;

import baseball.domain.game.Game;
import baseball.domain.game.SoleConsoleGame;

public class GameInitializer {

	public static Game getGame() {
		SoleConsoleGameFactory factory = new SoleConsoleGameFactory();
		return new SoleConsoleGame(factory, factory.getDefender(), factory.getAttacker());
	}
}
