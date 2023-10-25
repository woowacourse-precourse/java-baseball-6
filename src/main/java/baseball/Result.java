package baseball;

public class Result {
    private final int strike;
    private final int ball;

    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() { return this.strike; }
    public int getBall() { return this.ball; }

    public String getMessage() {
        if ( isAllStrike() ) { return "ALL STRIKE"; }
        if ( isStrike() ) { return strike + "STRIKE"; }
        if ( isBall() ) { return ball + "BALLS"; }
        if ( isStrikeBall() ) { return strike + "STRIKE, " + ball + "BALL"; }
        if ( isNoting() ) { return "NOTING"; }

        return "NOTING";
    }

    public static Result checkBalls(Balls com, Balls user) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < Balls.BALLS_COUNT; i++) {
            Ball thisCom = com.getBallsByIndex(i);
            Ball thisUser = user.getBallsByIndex(i);

            if ( thisCom.equals(thisUser) ) {
                strike++;
                continue;
            }

            if ( user.contains(thisCom) ) {
                ball++;
            }
        }

        return new Result(strike, ball);
    }

    public boolean isNoting() { return strike == 0 && ball == 0; }
    public boolean isStrike() { return strike > 0 && ball == 0; }
    public boolean isBall() { return strike == 0 && ball > 0; }
    public boolean isStrikeBall() { return strike > 0 && ball > 0; }
    public boolean isAllStrike() { return strike == Balls.BALLS_COUNT; }
}
