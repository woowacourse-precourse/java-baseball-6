package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Reader {

    private Reader() {
        throw new UnsupportedOperationException();
    }

    public static String readInput() {
        return Console.readLine();
    }
}
