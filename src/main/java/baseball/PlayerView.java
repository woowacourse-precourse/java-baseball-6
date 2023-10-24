package baseball;

import camp.nextstep.edu.missionutils.Console;

public class PlayerView {
    public String input() {
        return Console.readLine();
    }

    public void output(String message) {
        System.out.print(message);
    }
}
