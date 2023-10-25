package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private String input;
    private boolean winning;

    public User() {
        this.input = "";
        this.winning = false;
    }

    public void win() {
        winning = true;
    }

    public void lose() {
        winning = false;
    }

    public boolean returnWinning() {
        return winning;
    }

    public String readConsoleInput() {
        input = Console.readLine();
        return input;
    }

    public String returnUserInputVal() {
        return input;
    }
}
