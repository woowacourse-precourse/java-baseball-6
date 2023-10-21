package baseball.util;

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

    private void printMessage(String message) {
        System.out.print(message);
    }
}
