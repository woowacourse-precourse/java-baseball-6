package baseball.view;

import static baseball.util.Constants.DEFAULT_VALUE;
import static baseball.util.Constants.VALUE_ONE;

import baseball.model.Result;
import baseball.util.ConsoleMessage;
import baseball.util.ResultHandler.BallAndStrikeHandler;
import baseball.util.ResultHandler.BallHandler;
import baseball.util.ResultHandler.NothingHandler;
import baseball.util.ResultHandler.ResultHandler;
import baseball.util.ResultHandler.StrikeHandler;
import baseball.util.resultFomat.ResultFormatter;

public class OutputView {

    public void printGameStart() {
        System.out.println(ConsoleMessage.START_GAME.getMessage());
    }

    public void printGameResult(Result result) {

        ResultFormatter formatter = getFormatter(result);
        System.out.println(formatter.format());
    }

    public void printThreeStrike() {
        System.out.println(ConsoleMessage.THREE_STRIKE.getMessage());
    }

    public void printExceptionMessage(Exception exception) {
        System.out.printf(exception.getMessage());
    }

    private ResultFormatter getFormatter(Result result) {
        ResultHandler startingHandler = createHandlerChain();
        return startingHandler.handleResult(result.getBall(), result.getStrike());
    }

    private ResultHandler createHandlerChain() {
        ResultHandler nothingHandler = createNothingHandler();
        ResultHandler ballHandler = createBallHandler();
        ResultHandler strikeHandler = createStrikeHandler();
        ResultHandler ballAndStrikeHandler = createBallAndStrikeHandler();

        setupHandlerChain(nothingHandler, ballHandler, strikeHandler, ballAndStrikeHandler);

        return nothingHandler;
    }

    private ResultHandler createNothingHandler() {
        return NothingHandler.createWithChain();
    }

    private ResultHandler createBallHandler() {
        return BallHandler.createBallHandler();
    }

    private ResultHandler createStrikeHandler() {
        return StrikeHandler.createStrikeHandler();
    }

    private ResultHandler createBallAndStrikeHandler() {
        return BallAndStrikeHandler.createBallAndStrikeHandler();
    }

    private void setupHandlerChain(ResultHandler... handlers) {
        setupHandlerChainRecursive(DEFAULT_VALUE, handlers);
    }

    private void setupHandlerChainRecursive(int index, ResultHandler... handlers) {
        if (index >= handlers.length - VALUE_ONE) {
            return;
        }

        handlers[index].setNextHandler(handlers[index + VALUE_ONE]);
        setupHandlerChainRecursive(index + VALUE_ONE, handlers);
    }
}