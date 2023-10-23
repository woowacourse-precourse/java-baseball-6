package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.game.Game;
import baseball.util.Utility;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        game.play();
    }
}
