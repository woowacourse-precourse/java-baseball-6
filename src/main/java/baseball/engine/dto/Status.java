package baseball.engine.dto;

public class Status {
    private static final int ALL_STRIKE = 3;
    private int strike;
    private int ball;

    private Status() {
    }

    public Status(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isAllStrike() {
        return this.strike == ALL_STRIKE;
    }

    public String getResult() {
        StringBuilder result = new StringBuilder();
        if (this.isExistBall()) {
            result.append(this.ball).append("볼 ");
        }
        if (this.isExistStrike()) {
            result.append(this.strike).append("스트라이크");
        }
        if(result.isEmpty()){
            result.append("낫싱");
        }
        result.append("\n");

        return result.toString();
    }

    private boolean isExistBall() {
        return this.ball > 0;
    }

    private boolean isExistStrike() {
        return this.strike > 0;
    }
}
