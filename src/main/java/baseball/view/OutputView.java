package baseball.view;

import baseball.model.Result;
import baseball.util.ConsoleMessage;
import baseball.util.ExceptionMessage;
import java.util.List;

public class OutputView {
    public void printGameStart() {
        System.out.println(ConsoleMessage.START_GAME);
    }

    public void printComputerNumber(List<Integer> computerNumber) {
        System.out.println(computerNumber);
    }

    public void printGameResult(Result result) {
        System.out.println(result.getFormattedResult());
    }

    public void printThreeStrike() {
        System.out.println(ConsoleMessage.THREE_STRIKE.getMessage());
    }

    public void printExceptionMessage(Exception exception) {
        System.out.printf(ExceptionMessage.BASE.getMessage(), exception.getMessage());
    }
}