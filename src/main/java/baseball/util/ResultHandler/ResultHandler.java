package baseball.util.ResultHandler;

import baseball.util.resultFomat.ResultFormatter;

public interface ResultHandler {
    void setNextHandler(ResultHandler nextHandler);

    ResultFormatter handleResult(int ball, int strike);
}