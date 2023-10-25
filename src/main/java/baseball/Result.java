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
        if ( isAllStrike() ) { return "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"; }
        if ( isStrike() ) { return strike + "스트라이크"; }
        if ( isBall() ) { return ball + "볼"; }
        if ( isStrikeBall() ) { return ball + "볼" + strike + "스트라이크"; }
        if ( isNoting() ) { return "낫싱"; }

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
