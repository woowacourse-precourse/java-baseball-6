package baseball;

public class Result {
    private int strike;
    private int ball;

    public Result() {
        this.strike = 0;
        this.ball = 0;
    }

    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    @Override
    public String toString() {
        return "";
    }

    public void addStrike(){
        this.strike++;
    }
    public void addBall(){
        this.ball++;
    }

    //== 테스트용 메서드==//

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
