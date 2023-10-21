package baseball.util;

import baseball.domain.score.ImmutableBallStrikeCount;
import baseball.util.constant.GameMessage;

public class MessagePrinterImpl implements MessagePrinter {

    @Override
    public void printStartMessage() {
        printMessage(GameMessage.START.getMessage());
    }

    @Override
    public void printBatterRequest() {
        printMessage(GameMessage.REQUEST_BAT.getMessage());
    }

    @Override
    public void printBallAndStrike(ImmutableBallStrikeCount ballStrikeCount) {
        printMessage(ballStrikeCount.toFormattedResult());
    }

    @Override
    public void printEndAndRequestCommand() {
        printMessage(GameMessage.END.getMessage());
        printMessage(GameMessage.REQUEST_COMMAND.getMessage());
    }

    private void printMessage(String message) {
        System.out.print(message);
    }
}
