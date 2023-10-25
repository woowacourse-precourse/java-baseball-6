package baseball;

import static baseball.status.GameMsg.GAME_START;

import baseball.game.GameInputImpl;
import baseball.game.GameOutputImpl;
import baseball.game.GameUtilImpl;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println(GAME_START.getMsg());
        GameInputImpl gameInput = new GameInputImpl();
        GameOutputImpl gameOutput = new GameOutputImpl();
        GameUtilImpl gameUtil = new GameUtilImpl();
        Game game = new Game(gameInput, gameOutput, gameUtil);
        game.play();
        Console.close();
    }
}
