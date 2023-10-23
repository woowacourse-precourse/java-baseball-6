package baseball.model.baseball;

import baseball.constants.BaseballRole;

public class Ball {

    private int ballCount;

    public Ball(int count) {
        this.ballCount = count;
    }

    public void updateBallCount(long count){
        this.ballCount = (int)count;
    }

    public boolean isNoCountBall(){
        return ballCount == BaseballRole.NO_COUNT.getValue();
    }

    public boolean isBall(){
        return ballCount != BaseballRole.NO_COUNT.getValue();
    }

    @Override
    public String toString() {
        return String.valueOf(ballCount);
    }
}
