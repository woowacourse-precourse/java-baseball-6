package baseball.controller;

import baseball.entity.Game;
import baseball.entity.Player;
import baseball.entity.Result;

public class GameController {

    public Result game(Player player,Game game) {
        player.setStrikeCount(game.countStrike(player.getInputString()));
        player.setBallCount(game.countBall(player.getInputString()));
        player.setGameWin(game.isAnswer(player.getInputString()));

        return new Result(player.isGameWin(), player.getStrikeCount(), player.getBallCount());
    }
}
