package baseball.handler;

import baseball.domain.GameResult;

public interface OutputHandler {

    public void printGameStart();
    public void printGameResult(String result);
}
