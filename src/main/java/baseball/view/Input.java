package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String gameStart() {
        Output.printInputGame();
        return Console.readLine();
    }

    public static String gameRestart() {
        Output.printRestart();
        return Console.readLine();
    }
}
