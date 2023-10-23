package baseball.model.baseball;

import baseball.constants.message.BaseballMessage;
import baseball.model.player.Player;

import java.util.List;

public class BaseballManager {

    private static final int NO_COUNT = 0;
    private final BaseballGame baseballGame;
    private final Ball ball;
    private final Strike strike;

    public BaseballManager() {
        this.baseballGame = new BaseballGame();
        this.ball = new Ball(NO_COUNT);
        this.strike = new Strike(NO_COUNT);
    }

    public void updateBallAndStrike(Player player){
        List<Integer> baseballNumbers = baseballGame.getBaseballNumbers();
        ball.updateBallCount(player.compareBallCount(baseballNumbers));
        strike.updateStrikeCount(player.compareStrikeCount(baseballNumbers));
    }

    public String statusBallAndStrike(){
        StringBuilder message = new StringBuilder();
        appendNothing(message);
        appendBallCount(message);
        appendStrikeCount(message);
        return message.toString();
    }

    private void appendNothing(StringBuilder message) {
        if (ball.isNoCountBall() && strike.isNoCountStrike()){
            message.append(BaseballMessage.NOTHING);
        }
    }

    private void appendBallCount(StringBuilder message) {
        if (ball.isBall()){
            message.append(ball).append(BaseballMessage.BALL).append(BaseballMessage.BLANK);
        }
    }

    private void appendStrikeCount(StringBuilder message) {
        if (strike.isStrike()){
            message.append(strike).append(BaseballMessage.STRIKE);
        }
    }

    public boolean isThreeStrike(){
        return strike.isThreeStrike();
    }

}
