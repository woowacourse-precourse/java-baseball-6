package baseball.util.ResultHandler;

import static baseball.util.Constants.DEFAULT_VALUE;

import baseball.util.resultFomat.BallFormatter;
import baseball.util.resultFomat.ResultFormatter;

public class BallHandler implements ResultHandler {
    private ResultHandler nextHandler;

    public static BallHandler createBallHandler() {
        return new BallHandler();
    }

    @Override
    public void setNextHandler(ResultHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public ResultFormatter handleResult(int ball, int strike) {
        if (isZero(strike)) {
            return new BallFormatter(ball);
        }
        return nextHandler.handleResult(ball, strike);
    }

    private boolean isZero(int number) {
        return Integer.valueOf(DEFAULT_VALUE).equals(Integer.valueOf(number));
    }
}