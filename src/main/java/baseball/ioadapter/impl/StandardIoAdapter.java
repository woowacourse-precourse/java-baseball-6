package baseball.ioadapter.impl;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.ioadapter.IoAdapter;
import baseball.message.GameMessages;

public class StandardIoAdapter implements IoAdapter {
    @Override
    public String inputStream() {
        return readLine();
    }

    @Override
    public void printMessage(GameMessages gameMessages) {
        if (gameMessages == GameMessages.NUMBER_INPUT_COMMENT) {
            System.out.print(gameMessages.getMessage());
        } else {
            System.out.println(gameMessages.getMessage());
        }
    }
}
