package baseball.model.baseball;

public class Ball {

    private static final int NO_COUNT = 0;
    private int ballCount;

    public Ball(int count) {
        this.ballCount = count;
    }

    public void updateBallCount(long count){
        this.ballCount = (int)count;
    }

    public boolean isNoCountBall(){
        return ballCount == NO_COUNT;
    }

    public boolean isBall(){
        return ballCount != NO_COUNT;
    }

    @Override
    public String toString() {
        return String.valueOf(ballCount);
    }
}
