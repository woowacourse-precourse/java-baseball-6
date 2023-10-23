package baseball.service;

import baseball.constant.Message;
import camp.nextstep.edu.missionutils.Console;

public class IOService {

    public void println(Message message) {
        System.out.println(message.text());
    }

    public void println(String hint) {
        System.out.println(hint);
    }

    public void print(Message message) {
        System.out.print(message.text());
    }

    public String readInput(Message message) {
        checkMessagePrint(message);
        return readInput();
    }

    private void checkMessagePrint(Message message) {
        if (message.isNeedPrint()) {
            print(message);
        } else {
            println(message);
        }
    }

    private String readInput() {
        return Console.readLine();
    }
}
