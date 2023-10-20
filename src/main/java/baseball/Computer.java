package baseball;

public class Computer {
    private BallArray ballArray;

    public void setRandomBallArray() {
        ballArray = BaseballBallFactory.createRanDomBall();
    }

    public BallResult getUserBallResult(BallArray userBallArr) {
        return ballArray.compareWith(userBallArr);
    }

}


