package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameStarter {


    public static int getPlayerInput() {
        MessagePrinter.printGetNumberMessage();
        String userNumber = Console.readLine();
        InputValidator.checkPlayerNumber(userNumber);

        return Integer.parseInt(userNumber);
    }

}
