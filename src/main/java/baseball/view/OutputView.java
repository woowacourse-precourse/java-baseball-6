package baseball.view;

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
        ResultHandler nothingHandler = new NothingHandler();
        ResultHandler ballHandler = new BallHandler();
        ResultHandler strikeHandler = new StrikeHandler();
        ResultHandler ballAndStrikeHandler = new BallAndStrikeHandler();

        nothingHandler.setNextHandler(ballHandler);
        ballHandler.setNextHandler(strikeHandler);
        strikeHandler.setNextHandler(ballAndStrikeHandler);

        return nothingHandler.handleResult(result.getBall(), result.getStrike());
    }
}