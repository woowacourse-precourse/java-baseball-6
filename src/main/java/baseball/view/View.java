package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import static baseball.constants.Constants.*;

public class View {
    public void printStart() {
        System.out.println(START_COMMENT);
    }

    public String inputNumber() {
        System.out.print(INPUT_COMMENT);
        return Console.readLine();
    }

    public void printResult(String result) {
        System.out.println(result);
    }

    public String inputEnd() {
        System.out.println(END_COMMENT);
        return Console.readLine();
    }

    public void closeConsole() {
        Console.close();
    }
}
