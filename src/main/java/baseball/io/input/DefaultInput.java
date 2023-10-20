package baseball.io.input;

import camp.nextstep.edu.missionutils.Console;

public class DefaultInput implements Input {

    private final String messagePrefix;

    public DefaultInput(String messagePrefix) {
        this.messagePrefix = messagePrefix;
    }

    @Override
    public String nextLine() {
        System.out.print(messagePrefix);
        return Console.readLine();
    }

    public String nextLineWithNoEffect() {
        return Console.readLine();
    }
}
