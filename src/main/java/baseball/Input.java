package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private Input() {}
    public static String inputPlayerNumbers() {
        Output.printInputNumbersMessage();
        return Console.readLine();
    }

    public static String inputRestartOption() {
        return Console.readLine();
    }
}
