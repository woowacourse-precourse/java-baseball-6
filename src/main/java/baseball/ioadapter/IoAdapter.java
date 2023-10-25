package baseball.ioadapter;

import baseball.message.GameMessages;
import baseball.vo.Message;

public interface IoAdapter {

    String inputStream();

    void printMessage(GameMessages gameMessages);

    void printResult(Message message);
}
