package baseball.game.validator;

import java.util.List;

public class GameLogic {
    private int ball = 0;
    private int strike = 0;
    public GameResult logic(List<Integer> player, List<Integer> ans) {
        reset();
        ballCount(player,ans);
        strikeCount(player,ans);
        adjustCount();
        return new GameResult(ball, strike);
    }

    private void adjustCount() {
        ball = ball - strike;
    }

    public void ballCount(List<Integer> player, List<Integer> ans){
        for (Integer playerNum : player) {
            if (ans.contains(playerNum)) {
                ball++;
            }
        }
    }

    public void strikeCount(List<Integer> player, List<Integer> ans){
        for (Integer playerNum : player) {
            if (ans.indexOf(playerNum) == player.indexOf(playerNum)) {
                strike ++;
            }
        }
    }
    public void reset(){
        ball = 0;
        strike = 0;
    }
}
