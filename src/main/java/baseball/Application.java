package baseball;

import baseball.controller.GameController;
import baseball.controller.InputController;
import baseball.controller.OutputController;
import baseball.entity.Game;
import baseball.entity.Player;
import baseball.entity.Result;

import static baseball.controller.OutputController.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Game game = new Game();

        Player player = new Player();
        InputController inputController = new InputController();
        OutputController outputController = new OutputController();
        GameController gameController = new GameController();
        game.printAnswer();
        outputController.cliOutputln(START);

        while (true) {


        outputController.cliOutput(INPUT);
        player.setInputString(inputController.playerInput());
        Result result = gameController.game(player, game);

            System.out.println(player.getInputString());

            if (result.isAnswer) {
                outputController.cliOutputln(ANSWER);
                outputController.cliOutputln(AFTER);
                break;
            } else if (result.strike == 0 && result.ball != 0) {
                System.out.print(result.ball);
                outputController.cliOutputln(BALL);
            } else if (result.strike != 0 && result.ball == 0) {
                System.out.print(result.strike);
                outputController.cliOutputln(STRIKE);
            } else {
                System.out.print(result.ball);
                outputController.cliOutput(BALL);
                System.out.print(result.strike);
                outputController.cliOutputln(STRIKE);
            }



        }
    }
}
