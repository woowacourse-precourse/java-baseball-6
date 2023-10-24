package baseball.ioadapter;

import baseball.message.GameMessages;

public interface IoAdapter {

    String inputStream();

    void printMessage(GameMessages gameMessages);
}
