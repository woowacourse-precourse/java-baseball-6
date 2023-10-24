package baseball.controller;

import baseball.entity.Game;
import baseball.entity.Input;
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

    public void before() {
        game.initAnswer();
    }

    public void start() {
        before();
        boolean gameResult=false;
        while (!gameResult) {
            gameResult = baseballGame();
        }
        re();
    }


    public boolean baseballGame() {
        outputController.printNotice(INPUT);
        Input input = inputController.playerInput(true);
        player.setInputString(input.getInputString());
        Result result = game(player, game);

        outputController.printResult(result.strike, result.ball);
        if (result.isAnswer) {
            outputController.printNoticeln(ANSWER);
            return true;
        }
        return false;
    }

    public void re() {
        outputController.printNoticeln(AFTER);
        Input input = inputController.playerInput(false);
        if (input.getInputString().equals("1") ){
            start();
        }
    }

    public Result game(Player player,Game game) {
        return new Result(game.isAnswer(player.getInputString()),game.countStrike(player.getInputString()), game.countBall(player.getInputString()) );
    }
}
