package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput {

    private ConsoleInput() {
    }

    public static String askInputNumber() {
        ConsoleOutput.print(ConsoleMessage.ENTER_NUMBER.getMessage());
        return Console.readLine();
    }

    public static String askRestart() {
        ConsoleOutput.print(ConsoleMessage.RESTART.getMessage());
        return Console.readLine();
    }

}
