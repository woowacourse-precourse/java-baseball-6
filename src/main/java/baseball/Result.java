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
        if (strike + ball == 0) {
            return "낫싱";
        }
        StringBuilder result = new StringBuilder();
        if (ball != 0) {
            result.append(ball + "볼");
        }
        if (strike != 0) {
            if (!result.isEmpty()) {
                result.append(" ");
            }
            result.append(strike + "스트라이크");
        }

        return result.toString();
    }

    public void addStrike() {
        this.strike++;
    }

    public void addBall() {
        this.ball++;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}