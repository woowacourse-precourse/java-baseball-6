package baseball.model;

import baseball.constants.message.BaseballMessage;
import baseball.constants.BaseballRole;

import java.util.List;

public class BaseballManager {

    private static final int NO_COUNT = 0;
    private final BaseballGame baseballGame;
    private int ball;
    private int strike;

    public BaseballManager() {
        this.baseballGame = new BaseballGame();
        this.ball = NO_COUNT;
        this.strike = NO_COUNT;
    }

    public void updateBallAndStrike(Player player){
        List<Integer> baseballNumbers = baseballGame.getBaseballNumbers();
        this.ball = (int)player.compareBallCount(baseballNumbers);
        this.strike = (int)player.compareStrikeCount(baseballNumbers);
    }

    public String statusBallAndStrike(){
        StringBuilder message = new StringBuilder();
        appendNothing(message);
        appendBallCount(message);
        appendStrikeCount(message);
        return message.toString();
    }

    private void appendNothing(StringBuilder message) {
        if (ball == NO_COUNT && strike == NO_COUNT){
            message.append(BaseballMessage.NOTHING);
        }
    }

    private void appendBallCount(StringBuilder message) {
        if (ball != NO_COUNT){
            message.append(ball).append(BaseballMessage.BALL).append(BaseballMessage.BLANK);
        }
    }

    private void appendStrikeCount(StringBuilder message) {
        if (strike != NO_COUNT){
            message.append(strike).append(BaseballMessage.STRIKE);
        }
    }

    public boolean isThreeStrike(){
        return strike != BaseballRole.THREE_STRIKE.getValue();
    }

}
