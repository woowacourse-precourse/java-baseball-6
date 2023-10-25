package baseball.util.ResultHandler;

import baseball.util.resultFomat.NothingFormatter;
import baseball.util.resultFomat.ResultFormatter;

public class NothingHandler implements ResultHandler {
    private ResultHandler nextHandler;

    @Override
    public void setNextHandler(ResultHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public ResultFormatter handleResult(int ball, int strike) {
        if (strike == 0 && ball == 0) {
            return new NothingFormatter();
        }
        return nextHandler.handleResult(ball, strike);
    }
}
