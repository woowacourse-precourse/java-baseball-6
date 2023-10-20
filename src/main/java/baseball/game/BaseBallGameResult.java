package baseball.game;

public class BaseBallGameResult {
    private final int strike;
    private final int ball;

    private BaseBallGameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static BaseBallGameResult create(int strike, int ball){
        return new BaseBallGameResult(strike, ball);
    }
}
