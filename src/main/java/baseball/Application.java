package baseball;

import static baseball.status.GameMsg.GAME_START;

import baseball.game.GameInput;
import baseball.game.GameOutput;
import baseball.game.GameUtil;
import baseball.game.impl.GameInputImpl;
import baseball.game.impl.GameOutputImpl;
import baseball.game.impl.GameUtilImpl;

public class Application {

    public static void main(String[] args) {
        System.out.println(GAME_START.getMsg());

        GameInput gameInput = new GameInputImpl();
        GameOutput gameOutput = new GameOutputImpl();
        GameUtil gameUtil = new GameUtilImpl();

        Game game = new Game(gameInput, gameOutput, gameUtil);
        game.play();
        
        gameInput.close();
    }
}
