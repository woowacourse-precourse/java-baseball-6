package baseball.domain;

public class GameResult {
    private final Integer MAX_STRIKE_COUNT = 3;
    private final Integer MAX_BALL_COUNT = 3;

    private final Integer MIN_STRIKE_COUNT = 0;

    private final Integer MIN_BALL_COUNT = 0;
    private final Integer strike;
    private final Integer ball;

    public GameResult(Integer strike, Integer ball) {
        validateStrikeRange(strike);
        validateBallRange(ball);
        this.strike = strike;
        this.ball = ball;
    }

    private void validateStrikeRange(Integer strike) {
        if (!(MIN_STRIKE_COUNT <= strike && strike <= MAX_STRIKE_COUNT))
            throw new IllegalStateException("[error] 결과 생성에 실패했습니다. 스트라이크의 개수가 허용 범위를 벗어났습니다.");
    }

    private void validateBallRange(Integer ball) {
        if (!(MIN_BALL_COUNT <= ball || ball <= MAX_BALL_COUNT))
            throw new IllegalStateException("[error] 결과 생성에 실패했습니다. 볼의 개수가 허용 범위를 벗어났습니다.");
    }


    public Integer getStrike() {
        return this.strike;
    }

    public Integer getBall() {
        return this.ball;
    }
}
