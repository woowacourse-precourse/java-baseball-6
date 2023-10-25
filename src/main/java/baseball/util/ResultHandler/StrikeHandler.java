package baseball.util.ResultHandler;

import baseball.util.resultFomat.ResultFormatter;
import baseball.util.resultFomat.StrikeFormatter;

public class StrikeHandler implements ResultHandler {
    private ResultHandler nextHandler;

    @Override
    public void setNextHandler(ResultHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public ResultFormatter handleResult(int ball, int strike) {
        if (ball == 0) {
            return new StrikeFormatter(strike);
        }
        return nextHandler.handleResult(ball, strike);
    }
}