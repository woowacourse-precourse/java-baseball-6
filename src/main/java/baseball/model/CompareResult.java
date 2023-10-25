package baseball.model;

public class CompareResult {

    private final Integer ball;
    private final Integer strike;

    public CompareResult(Integer ball, Integer strike) {
        validate(ball, strike);
        this.ball = ball;
        this.strike = strike;
    }

    public void validate(Integer ball, Integer strike) {
        if (ball < 0 || ball > 3 || strike < 0 || strike > 3) {
            throw new IllegalArgumentException("ball과 strike는 0 ~ 3 사이의 정수여야 합니다.");
        }

        if (ball + strike > 3) {
            throw new IllegalArgumentException("ball과 strike의 합은 3을 넘을 수 없습니다.");
        }
    }

    public Integer getBall() {
        return ball;
    }

    public Integer getStrike() {
        return strike;
    }
}
