package baseball.util.ResultHandler;

import static baseball.util.Constants.DEFAULT_VALUE;

import baseball.util.resultFomat.NothingFormatter;
import baseball.util.resultFomat.ResultFormatter;

public class NothingHandler implements ResultHandler {
    private ResultHandler nextHandler;

    public static NothingHandler createWithChain() {
        return new NothingHandler();

    }

    @Override
    public void setNextHandler(ResultHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public ResultFormatter handleResult(int ball, int strike) {
        if (isZero(strike) && isZero(ball)) {
            return new NothingFormatter();
        }
        return nextHandler.handleResult(ball, strike);
    }

    private boolean isZero(int number) {
        return number == DEFAULT_VALUE;
    }


}