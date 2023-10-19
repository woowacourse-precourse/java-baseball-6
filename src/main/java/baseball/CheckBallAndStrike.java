package baseball;

import java.util.List;

public class CheckBallAndStrike {

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
}
