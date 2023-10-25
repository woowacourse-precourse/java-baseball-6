package baseball;

import baseball.game.BaseBallGame;
import camp.nextstep.edu.missionutils.Console;

public class Application {

	public static void main(String[] args) {
		BaseBallGame game = BaseBallGame.newGame();
		do {
			game.play();
		} while (game.askReplay());
		Console.close();
	}
}
