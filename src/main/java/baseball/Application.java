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

        InputController inputController = new InputController();
        OutputController outputController = new OutputController();
        GameController gameController = new GameController();
        outputController.cliOutputln(START);
        Game game;
        Player player;

        while (true) {
            boolean flag = false;

            game = new Game();

            player  = new Player();

            game.printAnswer();


            while (true) {


                outputController.cliOutput(INPUT);
                player.setInputString(inputController.playerInput());
                Result result = gameController.game(player, game);

                System.out.println(player.getInputString());
                if (result.strike != 0 && result.ball == 0) {
                    System.out.print(result.strike);
                    outputController.cliOutputln(STRIKE);

                    if (result.isAnswer) {
                        outputController.cliOutputln(ANSWER);
                        outputController.cliOutputln(AFTER);
                        String regame = inputController.reGameInput();
                        if (regame.equals("1") ){
                            System.out.println("here");
                            flag = true;
                        }
                        break;
                    }
                }
                 else if (result.strike == 0 && result.ball != 0) {
                    System.out.print(result.ball);
                    outputController.cliOutputln(BALL);
                }else if (result.strike == 0 && result.ball == 0) {

                    outputController.cliOutputln(NOTHING);
                }
                else {
                    System.out.print(result.ball);
                    outputController.cliOutput(BALL);
                    outputController.cliOutput(" ");
                    System.out.print(result.strike);
                    outputController.cliOutputln(STRIKE);
                }


            }
            System.out.println(flag);
            if (!flag) {
                break;
            }
        }
    }

    private void init() {
    }

    private void initgame() {
    }
}
