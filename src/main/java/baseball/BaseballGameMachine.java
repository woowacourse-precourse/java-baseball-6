package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameMachine {
    public String input() {
        return Console.readLine();
    }

    public void play() {
        startMessage();
    }

    public void startMessage() {
        Message message = new Message();
        System.out.println(message.start() + '\n');
    }
}
