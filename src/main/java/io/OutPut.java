package io;

import domain.result.GameResult;

public interface OutPut {

    void printStartGame();

    void printEnterNumberMsg();

    void printResult(GameResult gameResult);

    void printEndMessage();

    void printEndOrRetryMessage();


}
