package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private String input;

//    Player() {
//        input = Console.readLine();
//    }

    public void setInput() {
        input = Console.readLine();
    }

    public String getInput() {
        return input;
    }
}
