package baseball.core;

import baseball.game.GameResult;

import java.util.List;

public class GameLogic {
    public GameResult logic(List<Integer> player, List<Integer> ans) {
        int ball = ballCount(player, ans);
        int strike = strikeCount(player, ans);
        ball = ball - strike;
        return new GameResult(ball, strike);
    }

    public int ballCount(List<Integer> player, List<Integer> ans){
        int ball = 0;
        for (Integer playerNum : player) {
            if (ans.contains(playerNum)) {
                ball++;
            }
        }
        return ball;
    }

    public int strikeCount(List<Integer> player, List<Integer> ans){
        int strike = 0;
        for (Integer playerNum : player) {
            if (ans.indexOf(playerNum) == player.indexOf(playerNum)) {
                strike ++;
            }
        }
        return strike;
    }
}
