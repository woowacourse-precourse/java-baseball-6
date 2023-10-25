package baseball.util.ResultHandler;

import baseball.util.resultFomat.BallFormatter;
import baseball.util.resultFomat.ResultFormatter;

public class BallHandler implements ResultHandler {
    private ResultHandler nextHandler;

    @Override
    public void setNextHandler(ResultHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public ResultFormatter handleResult(int ball, int strike) {
        if (strike == 0) {
            return new BallFormatter(ball);
        }
        return nextHandler.handleResult(ball, strike);
    }
}