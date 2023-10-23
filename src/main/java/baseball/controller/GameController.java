package baseball.controller;

import baseball.entity.Game;
import baseball.entity.Player;
import baseball.entity.Result;

import static baseball.controller.OutputController.*;
import static baseball.controller.OutputController.STRIKE;

public class GameController {

    InputController inputController;
    OutputController outputController;
    Game game;
    Player player;

    public GameController(InputController inputController, OutputController outputController, Game game, Player player) {
        this.inputController = inputController;
        this.outputController = outputController;
        this.game = game;
        this.player = player;
    }

    public void baseballGame() {

        while (true) {
            outputController.printNotice(INPUT);
            player.setInputString(inputController.playerInput());
            Result result = game(player, game);

            outputController.printResult(result.strike, result.ball);
            if (result.isAnswer) {
                outputController.printNoticeln(ANSWER);
                return;
            }
        }

    }

    public boolean re() {
        outputController.printNoticeln(AFTER);
        String regame = inputController.reGameInput();
        if (regame.equals("1") ){
            return true;
        }
        return false;
    }

    public Result game(Player player,Game game) {
        player.setStrikeCount(game.countStrike(player.getInputString()));
        player.setBallCount(game.countBall(player.getInputString()));
        player.setGameWin(game.isAnswer(player.getInputString()));

        return new Result(player.isGameWin(), player.getStrikeCount(), player.getBallCount());
    }
}
