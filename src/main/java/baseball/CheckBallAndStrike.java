package baseball;

import java.util.List;

public class CheckBallAndStrike {

    private static final int NO_COUNT = 0;
    private static final int THREE_STRIKE = 3;

    private int ball;
    private int strike;
    private final List<Integer> baseballNumbers;

    public CheckBallAndStrike() {
        this.ball = 0;
        this.strike = 0;
        this.baseballNumbers = RandomNumberCreateUtil.createBaseballNumbers();
    }

    public void updateBallAndStrike(Player player){
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
        return strike != THREE_STRIKE;
    }

}
