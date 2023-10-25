package baseball;

public class BallChecker {
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    public static final int BALL_COUNT = 3;

    final int strike;
    final int ball;

    public BallChecker(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static BallChecker checkBalls(Balls com, Balls user) {
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

        return new BallChecker(strike, ball);
    }

    public String getMessage() {
        if ( isStrike() ) { return strike + STRIKE; }
        if ( isBall() ) { return ball + BALL; }
        if ( isStrikeBall() ) { return ball + BALL + strike + STRIKE; }
        if ( isNoting() ) { return NOTHING; }

        return "NOTING";
    }

    private boolean isNoting() { return strike == 0 && ball == 0; }
    private boolean isStrike() { return strike > 0 && ball == 0; }
    private boolean isBall() { return strike == 0 && ball > 0; }
    private boolean isStrikeBall() { return strike > 0 && ball > 0; }
    public boolean isAllStrike() { return strike == Balls.BALLS_COUNT; }
}
