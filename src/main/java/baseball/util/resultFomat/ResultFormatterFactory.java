package baseball.util.resultFomat;

public class ResultFormatterFactory {
    public static ResultFormatter create(int ball, int strike) {
        if (strike == 0 && ball == 0) {
            return new NothingFormatter();
        }
        if (strike == 0) {
            return new BallFormatter(ball);
        }
        if (ball == 0) {
            return new StrikeFormatter(strike);
        }
        return new BallAndStrikeFormatter(ball, strike);
    }
}

