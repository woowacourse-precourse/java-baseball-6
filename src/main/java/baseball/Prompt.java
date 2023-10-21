package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Prompt {

    public Prompt() {
    }

    public void print(Message outputMessage) {
        System.out.print(outputMessage.getMessage());
    }

    public String input() {
        return Console.readLine();
    }
}
