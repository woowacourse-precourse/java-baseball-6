package baseball;

import baseball.controller.GameController;
import baseball.controller.InputController;
import baseball.controller.OutputController;
import baseball.entity.Game;
import baseball.entity.Player;

import static baseball.controller.OutputController.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputController inputController = new InputController();
        OutputController outputController = new OutputController();
        Game game = new Game();
        Player player=new Player();
        GameController gameController = new GameController(inputController,outputController,game,player);

        gameController.start();
    }
}


