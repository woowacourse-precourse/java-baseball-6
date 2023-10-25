package baseball;

import static baseball.status.GameMsg.GAME_START;

import baseball.game.GameInput;
import baseball.game.GameOutput;
import baseball.game.GameUtilImpl;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println(GAME_START.getMsg());
        GameUtilImpl gameUtil = new GameUtilImpl();
        GameInput gameInput = new GameInput();
        GameOutput gameOutput = new GameOutput();
        Game game = new Game(gameInput, gameOutput, gameUtil);
        game.play();
        Console.close();
    }
}
