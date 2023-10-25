package baseball;

import baseball.game.BaseBallGame;

public class Application {

	public static void main(String[] args) {
		BaseBallGame game = BaseBallGame.newGame();
		do {
			game.play();
		} while (game.askReplay());
	}
}
