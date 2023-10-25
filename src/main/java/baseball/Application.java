package baseball;

import baseball.game.Game;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        Game game = new Game();

        game.welcome();
        do {
            game.play();
        } while (game.isAgain(Console.readLine()));
    }
}