package baseball.console;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String receiveBaseballNumber() {
        System.out.print(Constant.INPUT_BASEBALL_GAME_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public String receiveRestartNumber() {
        System.out.println(Constant.INPUT_BASEBALL_GAME_RESTART_MESSAGE);
        return Console.readLine();
    }
}
