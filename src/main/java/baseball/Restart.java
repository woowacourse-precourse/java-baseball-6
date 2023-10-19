package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Restart {
    public boolean inputRestartNumber() {
        String number = Console.readLine();
        if (number.equals("1")) {
            return true;
        } else if (number.equals("2")) {
            return false;
        } else throw new IllegalArgumentException();
    }
}
