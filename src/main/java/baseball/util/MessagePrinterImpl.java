package baseball.util;

import baseball.util.constant.GameMessage;

public class MessagePrinterImpl implements MessagePrinter {

    @Override
    public void printStartMessage() {
        printMessage(GameMessage.START.getMessage());
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
