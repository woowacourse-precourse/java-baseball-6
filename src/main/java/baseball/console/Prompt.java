package baseball.console;

import baseball.message.Message;
import camp.nextstep.edu.missionutils.Console;

public class Prompt {

    public Prompt() {
    }

    public void print(Message outputMessage) {
        System.out.print(outputMessage.getMessage());
    }

    public Prompt systme(Message message){
        return this;
    }

    public String input() {
        return Console.readLine();
    }
}
