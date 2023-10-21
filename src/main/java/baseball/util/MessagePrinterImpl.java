package baseball.util;

import static baseball.util.constant.GameMessage.START;

public class MessagePrinterImpl implements MessagePrinter {

    @Override
    public void printStartMessage() {
        printMessage(START.getMessage());
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
