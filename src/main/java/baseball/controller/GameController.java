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
        player.setInputString(inputController.playerInput());
        System.out.println(player.getInputString());
        game.printAnswer();
        Result result = game(player, game);
        System.out.println(result.strike +" "+result.ball);
        outputController.printResult(result.strike, result.ball);
        if (result.isAnswer) {
            outputController.printNoticeln(ANSWER);
            return true;
        }
        return false;
    }

    public void re() {
        outputController.printNoticeln(AFTER);
        String regame = inputController.reGameInput();
        if (regame.equals("1") ){
            start();
        }
    }

    public Result game(Player player,Game game) {
        return new Result(game.isAnswer(player.getInputString()),game.countStrike(player.getInputString()), game.countBall(player.getInputString()) );
    }
}
