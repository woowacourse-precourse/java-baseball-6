package baseball;

import camp.nextstep.edu.missionutils.Console;
public class User {
    public String inputNumber() {
        GameMessagesPrinter.inputNumberMessage();
        return Console.readLine();
    }
    public String choice() {
        return Console.readLine();
    }

}
