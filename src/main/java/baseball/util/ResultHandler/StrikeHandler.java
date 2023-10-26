package baseball.util.ResultHandler;

import static baseball.util.Constants.DEFAULT_VALUE;

import baseball.util.resultFomat.ResultFormatter;
import baseball.util.resultFomat.StrikeFormatter;

public class StrikeHandler implements ResultHandler {
    private ResultHandler nextHandler;

    public static StrikeHandler createStrikeHandler() {
        return new StrikeHandler();
    }

    @Override
    public void setNextHandler(ResultHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public ResultFormatter handleResult(int ball, int strike) {
        if (ball == DEFAULT_VALUE) {
            return new StrikeFormatter(strike);
        }
        return nextHandler.handleResult(ball, strike);
    }
}