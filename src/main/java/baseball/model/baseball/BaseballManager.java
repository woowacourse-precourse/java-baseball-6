package baseball.model.baseball;

import baseball.constants.BaseballRole;
import baseball.constants.message.BaseballMessage;
import baseball.model.player.Player;

import java.util.List;

public class BaseballManager {

    private final BaseballGame baseballGame;
    private final Ball ball;
    private final Strike strike;

    public BaseballManager() {
        this.baseballGame = new BaseballGame();
        this.ball = new Ball(BaseballRole.NO_COUNT.getValue());
        this.strike = new Strike(BaseballRole.NO_COUNT.getValue());
    }

    public void updateBallAndStrike(Player player){
        List<Integer> expectedNumbers = player.getExpectedNumbers();
        ball.updateBallCount(baseballGame.getBallCount(expectedNumbers));
        strike.updateStrikeCount(baseballGame.getStrikeCount(expectedNumbers));
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

    public boolean isClearGame(){
        return strike.isNotThreeStrike();
    }

}
