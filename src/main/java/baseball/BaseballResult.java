package baseball;

public class BaseballResult {
    private int strike = 0;
    private int ball = 0;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void addStrike() {
        this.strike += 1;
    }

    public void addBall() {
        this.ball += 1;
    }

    public boolean isSuccess() {
        if(strike == 3){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        if ((this.ball != 0) && (this.strike != 0)) {
            return this.ball + "볼 " + this.strike + "스트라이크";
        } else if(this.ball != 0) {
            return this.ball + "볼";
        } else if(this.strike != 0) {
            return this.strike + "스트라이크";
        } else {
            return "낫싱";
        }
    }
}
