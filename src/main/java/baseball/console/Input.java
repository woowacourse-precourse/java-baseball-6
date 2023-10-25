package baseball.console;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String receiveBaseballNumber() {
        Output.printBaseballGameNumberRequest();
        return Console.readLine();
    }

    public static String receiveRestartNumber() {
        Output.printBaseballGameRestartNumberRequest();
        return Console.readLine();
    }
}
